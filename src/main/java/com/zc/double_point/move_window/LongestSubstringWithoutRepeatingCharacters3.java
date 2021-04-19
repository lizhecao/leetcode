package com.zc.double_point.move_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhecao 2021/3/21
 * @version 1.0
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> windows = new HashMap<>();
    int max = 0;
    int right = 0,left = 0;
    while(right < s.length()) {
      // 要移入窗口的值
      char rc = s.charAt(right);
      // 右移窗口
      right++;
      windows.put(rc, windows.getOrDefault(rc, 0) + 1);

      // 是否要收缩窗口
      while (windows.getOrDefault(rc, 0) > 1) {
        // 要移出窗口的值
        char lc = s.charAt(left);
        // 左移窗口
        left++;

        windows.put(lc, windows.get(lc) - 1);
      }
      max = Math.max(max, right - left);
    }
    return max;
  }

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters3 l = new LongestSubstringWithoutRepeatingCharacters3();
    System.out.println(l.lengthOfLongestSubstring("tmmzuxt"));
  }
}
