package com.wesker926.leetcode.algorithms.p0764.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/11/9
 * @description 预处理DP
 * 计算每个点各个方向的长度，取其最小值
 * 然后找出所有点中的最大值
 */
public class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        boolean[] block = new boolean[n * n];
        for (int[] mine : mines) {
            block[mine[0] * n + mine[1]] = true;
        }
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0, c = 0; j < n; j++) {
                    int[] p = mapping(n, k, i, j);
                    c = block[p[0] * n + p[1]] ? 0 : c + 1;
                    dp[p[0]][p[1]] = Math.min(dp[p[0]][p[1]], c);
                }
            }
        }
        int ans = 0;
        for (int[] row : dp) {
            for (int i : row) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }

    private int[] mapping(int n, int k, int i, int j) {
        return new int[]{k < 2 ? i : (k == 2 ? j : n - 1 - j), k < 2 ? (k == 0 ? j : n - 1 - j) : i};
    }
}
