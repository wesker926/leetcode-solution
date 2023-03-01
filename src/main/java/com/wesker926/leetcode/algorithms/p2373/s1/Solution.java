package com.wesker926.leetcode.algorithms.p2373.s1;

/**
 * @author wesker.gh
 * @date 2023/3/1
 * @description 遍历
 * 这题可用二维单调队列来做
 */
public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        ans[i][j] = Math.max(ans[i][j], grid[i + k][j + l]);
                    }
                }
            }
        }
        return ans;
    }
}
