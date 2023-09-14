package com.zc.double_point.move_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhecao 2021/3/21
 * @version 1.0
 */
public class FindAllAnagramsInAString438 {
  public List<Integer> findAnagrams(String s, String p) {
    Map<Character, Integer> needs = new HashMap<>(),windows = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      needs.put(p.charAt(i), needs.getOrDefault(p.charAt(i), 0) + 1);
    }
    int valid = 0,right = 0,left = 0;
    List<Integer> result = new ArrayList<>();
    while(right < s.length()) {
      // 要移入窗口的值
      char rc = s.charAt(right);
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
      while (right - left == p.length()) {
        // 更新结果（当前有效的窗口）
        if (valid == needs.size()) {
          result.add(left);
        }

        // 要移出窗口的值
        char lc = s.charAt(left);
        // 左移窗口
        left++;
        // 更新窗口数据
        if (needs.containsKey(lc)) {
          if (windows.get(lc).equals(needs.get(lc))) {
            valid--;
          }
          windows.put(lc, windows.get(lc) - 1);
        }
      }
    }
    return result;
  }
}
