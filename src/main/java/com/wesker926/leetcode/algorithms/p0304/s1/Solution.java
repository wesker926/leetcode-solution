package com.wesker926.leetcode.algorithms.p0304.s1;

/**
 * @author wesker.gh
 * @date 2022/6/14
 * @description 二维前缀和
 */
public class Solution {

    private final int[][] matrix;

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
    public Solution(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        this.matrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                this.matrix[i][j] = matrix[i - 1][j - 1] + this.matrix[i - 1][j] + this.matrix[i][j - 1] - this.matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2 + 1][col2 + 1] - matrix[row1][col2 + 1] - matrix[row2 + 1][col1] + matrix[row1][col1];
    }
}
