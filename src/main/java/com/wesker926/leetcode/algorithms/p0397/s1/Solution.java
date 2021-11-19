package com.wesker926.leetcode.algorithms.p0397.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2021/11/19
 * @description dfs+缓存
 */
public class Solution {

    private static final Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 0);
    }

    public int integerReplacement(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int cur = (n & 1) == 0 ? integerReplacement(n >> 1) + 1 : Math.min(integerReplacement(n >> 1), integerReplacement((n >> 1) + 1)) + 2;
        map.put(n, cur);
        return cur;
    }
}
