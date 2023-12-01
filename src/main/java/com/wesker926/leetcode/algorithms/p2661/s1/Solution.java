package com.wesker926.leetcode.algorithms.p2661.s1;

/**
 * @author wesker.gh
 * @date 2023/12/1
 * @description 哈希表
 */
public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] idx = new int[m * n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                idx[mat[i][j]] = new int[]{i, j};
            }
        }
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int[] k = idx[arr[i]];
            row[k[0]]++;
            col[k[1]]++;
            if (row[k[0]] == n || col[k[1]] == m) return i;
        }
        return -1;
    }
}
