package com.wesker926.leetcode.algorithms.p1072.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/5/15
 * @description 哈希表
 * 非最优
 */
public class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            long cur = 0;
            for (int i = 0; i < row.length; i++) {
                cur = (cur << 1) | (row[i] ^ row[0]);
                if ((i & 63) == 63 || i == row.length - 1) {
                    String t = Long.toHexString(cur);
                    sb.append("0".repeat(16 - t.length())).append(t);
                    cur = 0;
                }
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int max = 0;
        for (int count : map.values()) max = Math.max(max, count);
        return max;
    }
}
