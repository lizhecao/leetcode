package com.zc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();
        boolean[] dp = new boolean[size+1];
        Set<String> map = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1;i <= size;i++) {
            dp[i] = false;
            for (int j = 0;j < i;j++) {
                if (map.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[size];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> dict = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(new WordBreak().wordBreak(s, dict));

        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println(new WordBreak().wordBreak(s1, dict1));
    }
}
