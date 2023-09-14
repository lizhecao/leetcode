package com.zc;

import java.util.HashMap;
import java.util.Map;

class IntegerReplacement {
    public int integerReplacement(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(Integer.MAX_VALUE, 32);
        return replaceHelp(n, map);
    }

    private int replaceHelp(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = 0;
        if (n % 2 == 0) {
            result = replaceHelp(n / 2, map);
        } else {
            result = Math.min(replaceHelp(n + 1, map), replaceHelp(n - 1, map));
        }
        map.put(n, result + 1);
        return result + 1;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(new IntegerReplacement().integerReplacement(n));
        n = 7;
        System.out.println(new IntegerReplacement().integerReplacement(n));
        n = 4;
        System.out.println(new IntegerReplacement().integerReplacement(n));
    }
}
