package com.wesker926.leetcode.algorithms.p1334.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/11/14
 * @description Floyd算法
 */
public class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] g = new int[n][n];
        for (int[] row : g) {
            Arrays.fill(row, Integer.MAX_VALUE >> 1);
        }
        for (int[] e : edges) {
            g[e[0]][e[1]] = g[e[1]][e[0]] = e[2];
        }

        for (int k = 0; k < n; k++) {
            g[k][k] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        int ans = -1, cnt = Integer.MAX_VALUE >> 1;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (g[i][j] <= distanceThreshold) c++;
            }
            if (c <= cnt) {
                cnt = c;
                ans = i;
            }
        }
        return ans;
    }
}
