package com.wesker926.leetcode.algorithms.p1267.s1;

/**
 * @author wesker.gh
 * @date 2023/8/24
 * @description 遍历计数
 */
public class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int[] stat = new int[m + n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                stat[i] += grid[i][j];
                stat[m + j] += grid[i][j];
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1 && (stat[i] > 1 || stat[m + j] > 1)) ans++;
        return ans;
    }
}
