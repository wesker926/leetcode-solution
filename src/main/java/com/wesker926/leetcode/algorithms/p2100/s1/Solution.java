package com.wesker926.leetcode.algorithms.p2100.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/3/6
 * @description 前缀和（DP）
 * 正反向统计当前非递增区间的长度即可
 */
public class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[][] counts = new int[2][n];
        for (int i = 1; i < n; i++) {
            counts[0][i] = security[i] <= security[i - 1] ? counts[0][i - 1] + 1 : 0;
            counts[1][n - 1 - i] = security[n - 1 - i] <= security[n - i] ? counts[1][n - i] + 1 : 0;
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (counts[0][i] >= time && counts[1][i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
