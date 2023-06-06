package com.wesker926.leetcode.algorithms.p2352.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/6/6
 * @description 哈希表
 */
public class Solution {

    private static final int MASK = 0b11110000000000000000;

    public int equalPairs(int[][] grid) {
        Map<String, Integer> count = new HashMap<>();
        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (int num : row) encode(sb, num);
            String key = sb.toString();
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        int ans = 0, n = grid.length;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) encode(sb, grid[j][i]);
            ans += count.getOrDefault(sb.toString(), 0);
        }
        return ans;
    }

    private void encode(StringBuilder sb, int num) {
        for (int i = MASK; i > 0; i >>= 4) sb.append(num & i);
    }
}
