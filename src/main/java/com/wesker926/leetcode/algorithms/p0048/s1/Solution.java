package com.wesker926.leetcode.algorithms.p0048.s1;

/**
 * @author wesker.gh
 * @date 2022/4/30
 * @description 翻转代替旋转
 * 第一种：先左上对角线翻转，再垂直中线翻转
 * 第二种：先右上对角线翻转，再水平中线翻转
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                swap(matrix, i, j, i, n - j - 1);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int t = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = t;
    }
}
