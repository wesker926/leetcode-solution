package com.wesker926.leetcode.algorithms.p0059.s1;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description 螺旋写入
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] steps = new int[][]{{0, 1, n}, {1, 0, n - 1}, {0, -1, n - 1}, {-1, 0, n - 2}};
        for (int i = 1, s = 0, x = 0, y = -1; steps[s][2] > 0; s = (s + 1) % 4) {
            for (int c = 0; c < steps[s][2]; c++) {
                x += steps[s][0];
                y += steps[s][1];
                matrix[x][y] = i++;
            }
            steps[s][2] -= 2;
        }
        return matrix;
    }
}
