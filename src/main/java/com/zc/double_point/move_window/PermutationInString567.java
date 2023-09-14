package com.zc.double_point.move_window;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口模板
 * @author lizhecao 2021/3/21
 * @version 1.0
 */
public class PermutationInString567 {
  public boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> needs = new HashMap<>(),windows = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      needs.put(s1.charAt(i), needs.getOrDefault(s1.charAt(i), 0) + 1);
    }
    int valid = 0,right = 0,left = 0;
    while(right < s2.length()) {
      // 要移入窗口的值
      char rc = s2.charAt(right);
      // 右移窗口
      right++;
      // 更新窗口数据
      if (needs.containsKey(rc)) {
        windows.put(rc, windows.getOrDefault(rc, 0) + 1);
        if (windows.get(rc).equals(needs.get(rc))) {
          valid++;
        }
      }

      // 是否要收缩窗口
      while (right - left == s1.length()) {
        // 更新结果（当前有效的窗口）
        if (valid == needs.size()) {
          return true;
        }

        // 要移出窗口的值
        char lc = s2.charAt(left);
        // 左移窗口
        left++;
        // 更新窗口数据
        if (needs.containsKey(lc)) {
          // 先判断lc是否刚好达到要求，再移动窗口
          if (windows.get(lc).equals(needs.get(lc))) {
            valid--;
          }
          windows.put(lc, windows.get(lc) - 1);
        }
      }
    }
    return false;
  }
}
