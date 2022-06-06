package com.wesker926.leetcode.algorithms.p0732.s2;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author wesker.gh
 * @date 2022/6/6
 * @description 差分数组
 */
public class Solution {

    private final TreeMap<Integer, Integer> calendar;

    public Solution() {
        calendar = new TreeMap<>();
    }

    public int book(int start, int end) {
        int ans = 0, cur = 0;
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) {
            cur += entry.getValue();
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
