package com.wesker926.leetcode.algorithms.p0594.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2021/11/20
 * @description 哈希表
 */
public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (map.containsKey(e.getKey() + 1)) {
                max = Math.max(max, map.get(e.getKey() + 1) + e.getValue());
            }
        }
        return max;
    }
}
