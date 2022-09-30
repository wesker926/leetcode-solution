package com.wesker926.leetcode.igc.p01_08.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/9/30
 * @description 单标记变量
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int firstRow = 1, m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    continue;
                }
                if (i == 0) {
                    firstRow = 0;
                } else {
                    matrix[i][0] = 0;
                }
                matrix[0][j] = 0;
            }
        }
        for (int i = m - 1; i > 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow == 0) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
