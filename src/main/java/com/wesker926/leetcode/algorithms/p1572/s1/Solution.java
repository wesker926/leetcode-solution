package com.wesker926.leetcode.algorithms.p1572.s1;

/**
 * @author wesker.gh
 * @date 2023/8/11
 * @description 遍历
 */
public class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = (n & 1) == 0 ? 0 : -mat[n >> 1][n >> 1];
        for (int i = 0; i < n; i++) sum += mat[i][i] + mat[i][n - 1 - i];
        return sum;
    }
}
