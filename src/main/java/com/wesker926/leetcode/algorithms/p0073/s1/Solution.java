package com.wesker926.leetcode.algorithms.p0073.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/5/5
 * @description 利用行头列头（一个标记变量）
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean clearFirstRow = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        clearFirstRow = true;
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (clearFirstRow) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
