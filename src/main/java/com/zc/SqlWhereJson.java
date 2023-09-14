package com.zc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.function.BiFunction;

/**
 * @author lizhecao 2021/4/28
 * @version 1.0
 */
public class SqlWhereJson {
  Map<String, Operation> operationMap = new HashMap<>();

  enum Operation {
    OR("or", 1, (x, y) -> {
      if (x.equals("false") && y.equals("false")) {
        return false;
      }
      return true;
    }),
    AND("and", 2, (x, y) -> {
      if (x.equals("true") && y.equals("true")) {
        return true;
      }
      return false;
    }),
    LIKE("like", 3, (x, y) -> {
      y = y.replace("\"", "");
      y = y.replace("%", ".*");
      return ((String) x).matches(y);
    }),
    GT(">", 3, (x, y) -> {
      Double xn = Double.valueOf(String.valueOf(x));
      Double yn = Double.valueOf(y);
      return xn > yn;
    }),
    LT("<", 3, (x, y) -> {
      Double xn = Double.valueOf(String.valueOf(x));
      Double yn = Double.valueOf(y);
      return xn < yn;
    }),
    EQ("=", 3, (x, y) -> {
      if (y.startsWith("\"")) {
        if (x instanceof String) {
          y = y.replace("\"", "");
          return x.equals(y);
        }
        return false;
      } else {
        //ToDo: 判断是否数字
        Double xn = Double.valueOf(String.valueOf(x));
        Double yn = Double.valueOf(y);
        return xn.equals(yn);
      }
    });

    Operation(String op, int priority, BiFunction<Object, String, Boolean> compareFunc) {
      this.op = op;
      this.priority = priority;
      this.compareFunc = compareFunc;
    }


    private String op;
    private int priority;
    private BiFunction compareFunc;

    public String getOp() {
      return op;
    }

    public void setOp(String op) {
      this.op = op;
    }

    public int getPriority() {
      return priority;
    }

    public void setPriority(int priority) {
      this.priority = priority;
    }

    public BiFunction getCompareFunc() {
      return compareFunc;
    }

    public void setCompareFunc(BiFunction compareFunc) {
      this.compareFunc = compareFunc;
    }

    public static Operation getByOp(String op) {
      for (Operation value : Operation.values()) {
        if (value.getOp().equals(op)) {
          return value;
        }
      }
      return null;
    }
  }


  public boolean isMatch(String json, String sql) {
    for (Operation operation : Operation.values()) {
      operationMap.put(operation.op, operation);
    }
    String[] ss = sql.split(" ");
    List<String> wordList = new ArrayList<>();
    for (String s : ss) {
      if (s.trim().length() > 0) {
        wordList.add(s);
      }
    }
    JSONObject jsonObject = JSON.parseObject(json);
    Stack<String> sk = new Stack<>();
    List<String> words = getSuffix(wordList);
    for (String word : words) {
      if (!operationMap.containsKey(word)) {
        sk.push(word);
      } else {
        Operation op = operationMap.get(word);
        String right = sk.pop();
        Object left;
        if (op.equals(Operation.AND) || op.equals(Operation.OR)) {
          left = sk.pop();
        } else {
          left = jsonObject.get(sk.pop());
        }
        sk.push(op.compareFunc.apply(left, right).toString());
      }
    }
    if (sk.size() == 1) {
      String result = sk.pop();
      if (result.equalsIgnoreCase("true")) {
        return true;
      }
    }
    return false;
  }

  private List<String> getSuffix(List<String> words) {
    Stack<String> opStack = new Stack<>();
    Stack<String> numStack = new Stack<>();
    for (String word : words) {
      if (!operationMap.containsKey(word)) {
        numStack.push(word);
      } else {
        boolean flag = true;
        while (flag) {
          if (opStack.empty()) {
            opStack.push(word);
            flag = false;
          } else {
            String lastWord = opStack.peek();
            if (operationMap.get(word).getPriority() >= operationMap.get(lastWord).getPriority()) {
              opStack.push(word);
              flag = false;
            } else {
              numStack.push(opStack.pop());
            }
          }
        }
      }
    }
    while (!opStack.empty()) {
      numStack.push(opStack.pop());
    }
    List<String> result = new ArrayList<>();
    String[] array = numStack.toArray(new String[]{});
    for (int i = 0; i < array.length; i++) {
      result.add(array[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    SqlWhereJson sqlWhereJson = new SqlWhereJson();
    String json = "{ " +
        " \"a\": 1, " +
        " \"b\": { " +
        "  \"c\": 1.23 " +
        " }, " +
        " \"d\": \"hello\" " +
        "}";
    String sql1 = "a = \"something\"";
    System.out.println(sqlWhereJson.isMatch(json, sql1));
    assert !sqlWhereJson.isMatch(json, sql1);

    String sql2 = "a = 2 and d like \"he%\" or a = 1";
    System.out.println(sqlWhereJson.isMatch(json, sql2));

    String sql3 = "a = 2 and d like \"he%\" or a = 1 and d like \"ha%\"";
    System.out.println(sqlWhereJson.isMatch(json, sql3));
    assert sqlWhereJson.isMatch(json, sql3);

    String sql4 = "a = 1 or d like \"ha%\" and a = 1 and d = \"hello\"";
    System.out.println(sqlWhereJson.isMatch(json, sql4));
    assert sqlWhereJson.isMatch(json, sql4);
  }
}
