package com.zc.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhecao 2021/3/20
 * @version 1.0
 */
public class Permutations46 {
  public List<List<Integer>> permute(int[] nums) {
    boolean []chosen = new boolean[nums.length];
    List<Integer> l = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, result, chosen, l);
    return result;
  }

  private void backtrack(int[] nums,List<List<Integer>> result,boolean[] chosen,List<Integer> l) {
    if (l.size() == nums.length) {
      result.add(new ArrayList<>(l));
    }

    for (int i = 0;i< nums.length;i ++) {
      if (chosen[i]) {
        continue;
      }
      chosen[i] = true;
      l.add(nums[i]);
      backtrack(nums, result, chosen, l);
      chosen[i] = false;
      l.remove(l.size() - 1);
    }
  }
}
