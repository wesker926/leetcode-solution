package com.wesker926.leetcode.algorithms.p0074.s1;

/**
 * @author wesker.gh
 * @date 2022/5/5
 * @description 二分
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1, f, x, y;
        while (l <= r) {
            f = (l + r) / 2;
            x = f / n;
            y = f % n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                l = f + 1;
            } else {
                r = f - 1;
            }
        }
        return false;
    }
}
