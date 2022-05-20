package com.wesker926.leetcode.algorithms.p0128.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/5/20
 * @description 哈希表（存区间）
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            int[] cur = map.computeIfAbsent(num, key -> new int[]{key, key});
            int[] left = map.getOrDefault(num - 1, cur);
            int[] right = map.getOrDefault(num + 1, cur);
            left = left != cur ? map.get(left[0]) : left;
            right = right != cur ? map.get(right[1]) : right;
            right[0] = left[0];
            left[1] = right[1];
        }
        int ans = 0;
        for (int[] interval : map.values()) {
            ans = Math.max(ans, interval[1] - interval[0] + 1);
        }
        return ans;
    }
}
