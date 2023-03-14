package com.wesker926.leetcode.algorithms.p1605.s1;

/**
 * @author wesker.gh
 * @date 2023/3/14
 * @description 贪心
 * 反证法易证
 * 注意行与列跳过，可极大减少执行时间
 */
public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (colSum[j] == 0) {
                    continue;
                }
                grid[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= grid[i][j];
                colSum[j] -= grid[i][j];
                if (rowSum[i] == 0) {
                    break;
                }
            }
        }
        return grid;
    }
}
