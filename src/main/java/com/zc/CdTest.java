package com.zc;

/**
 * @author lizhecao 2021/4/16
 * @version 1.0
 */
import java.util.Scanner;
public class CdTest {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
      int num = in.nextInt();
      in.nextLine();
      String result = "";
      for (int i = 0; i < num;i++) {
        String cur = in.nextLine();
        cur = cur.split("\\s")[1];
        if (cur.endsWith("/")) {
          cur = cur.substring(0, cur.length() - 1);
        }
        if (cur.startsWith("/")) {
          result = cur;
        } else {
          result += "/" + cur;
        }
      }
      while(result.contains("..")) {
        int i = result.indexOf("/..");
        if (i == 0) {
          result = result.substring(i + 3);
        } else {
          int l = i - 1;
          int r = i + 3;
          while (result.charAt(l) != '/') {
            l --;
          }
          result = result.substring(0, l) + result.substring(r);
        }
      }
      if (result.equals("")) {
        result = "/";
      }
      System.out.println(result);
    }
  }

}
