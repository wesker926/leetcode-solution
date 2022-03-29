package com.wesker926.leetcode.lcof.p004.s1;

/**
 * @author wesker.gh
 * @date 2022/3/29
 * @description 模拟BST
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        for (int i = 0, j = n - 1; i < m && j >= 0; ) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
