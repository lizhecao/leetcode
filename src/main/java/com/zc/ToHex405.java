package com.zc;

/**
 * @author lizhecao 2021/3/11
 * @version 1.0
 */
public class ToHex405 {
  public String toHex(int num) {
    String hexArr="0123456789abcdef";

    String hex = "";
    if (num == 0) {
      return "0";
    }
    while (num != 0) {
      hex = hexArr.charAt(num & 0xf) + hex;
      num >>>= 4;
    }
    return hex;
  }

  private String intToHex(int n) {
    switch (n) {
      case 10:
        return "a";
      case 11:
        return "b";
      case 12:
        return "c";
      case 13:
        return "d";
      case 14:
        return "e";
      case 15:
        return "f";
      default:
        return "" + n;
    }
  }

  public static void main(String[] args) {
    System.out.println(new ToHex405().toHex(-1));
  }
}
