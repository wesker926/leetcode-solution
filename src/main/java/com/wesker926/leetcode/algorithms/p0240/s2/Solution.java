package com.wesker926.leetcode.algorithms.p0240.s2;

/**
 * @author wesker.gh
 * @date 2021/10/25
 * @description 双维度二分
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        boolean mode = true;
        int[] nxt;
        while (l <= r && t <= b) {
            nxt = binary(matrix, target, l, r, t, b, mode);
            b = nxt[0];
            l = nxt[1];
            if (b >= t && l <= r && matrix[b][l] == target) {
                return true;
            }
            mode = !mode;
        }
        return false;
    }

    private int[] binary(int[][] matrix, int target, int l, int r, int t, int b, boolean mode) {
        int m1, m2, v;
        while (l <= r && t <= b) {
            m1 = mode ? b : t + (b - t) / 2;
            m2 = mode ? l + (r - l) / 2 : l;

            v = matrix[m1][m2];
            if (v == target) {
                return new int[]{m1, m2};
            }

            if (mode) {
                if (v > target) {
                    r = m2 - 1;
                } else {
                    l = m2 + 1;
                }
            } else {
                if (v > target) {
                    b = m1 - 1;
                } else {
                    t = m1 + 1;
                }
            }
        }
        return new int[]{b, l};
    }
}
