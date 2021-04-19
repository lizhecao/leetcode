package com.zc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhecao 2021/3/17
 * @version 1.0
 */
public class LetterCombinationsOfAPhoneNumber17 {
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits.equals("")) {
      return result;
    }

    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
      put('2', "abc");
      put('3', "def");
      put('4', "ghi");
      put('5', "jkl");
      put('6', "mno");
      put('7', "pqrs");
      put('8', "tuv");
      put('9', "wxyz");
    }};

    StringBuilder curString = new StringBuilder();
    backtrack(digits, 0, phoneMap, curString, result);
    return result;
  }

  private void backtrack(String digits, int i, Map<Character, String> phoneMap, StringBuilder curString,
                         List<String> result) {
    // 终止条件
    if (i == digits.length()) {
      result.add(curString.toString());
      return;
    }

    // 深度遍历
    String stringOfNum = phoneMap.get(digits.charAt(i));
    for (int j = 0; j < stringOfNum.length(); j++) {
      curString.append(stringOfNum.charAt(j));
      backtrack(digits, i + 1, phoneMap, curString, result);
      curString.deleteCharAt(i);
    }
  }

  public static void main(String[] args) {
    LetterCombinationsOfAPhoneNumber17 letterCombinationsOfAPhoneNumber17 = new LetterCombinationsOfAPhoneNumber17();
    System.out.println(letterCombinationsOfAPhoneNumber17.letterCombinations(""));
  }
}
