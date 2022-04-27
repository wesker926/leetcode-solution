package com.wesker926.leetcode.algorithms.p0417.s1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/27
 * @description DFS
 */
public class Solution {

    private static final int[][] POS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] visit = new int[m][n];
        for (int j = 0; j < n; j++) {
            dfs(heights, visit, 0, j, 1);
            dfs(heights, visit, m - 1, j, 2);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, visit, i, 0, 1);
            dfs(heights, visit, i, n - 1, 2);
        }
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 3) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] h, int[][] v, int i, int j, int t) {
        v[i][j] |= t;
        for (int[] p : POS) {
            int ni = i + p[0], nj = j + p[1];
            if (ni >= 0 && ni < h.length && nj >= 0 && nj < h[0].length && h[ni][nj] >= h[i][j] && (v[ni][nj] & t) == 0) {
                dfs(h, v, ni, nj, t);
            }
        }
    }
}
