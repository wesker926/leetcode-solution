package com.wesker926.leetcode.algorithms.p0240.s1;

/**
 * @author wesker.gh
 * @date 2021/10/25
 * @description BST
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = matrix[0].length - 1, r = 0;
        while (l >= 0 && r < matrix.length) {
            if (matrix[r][l] == target) {
                return true;
            } else if (matrix[r][l] > target) {
                l--;
            } else {
                r++;
            }
        }
        return false;
    }
}
