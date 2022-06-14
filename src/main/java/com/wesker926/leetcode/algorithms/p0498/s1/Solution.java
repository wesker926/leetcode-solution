package com.wesker926.leetcode.algorithms.p0498.s1;

/**
 * @author wesker.gh
 * @date 2022/6/14
 * @description 模拟
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, idx = 0;
        int min = Math.min(m, n), diff = Math.abs(m - n);
        int[] ans = new int[m * n];
        for (int i = 0; i < m + n - 1; i++) {
            int sx = i < m ? i : m - 1;
            int sy = i < m ? 0 : i - m + 1;
            int len = i < min - 1 ? i + 1 : (i < min + diff ? min : m + n - i - 1);
            if ((i & 1) == 1) {
                sx -= len - 1;
                sy += len - 1;
            }
            for (int j = 0; j < len; j++) {
                ans[idx++] = ((i & 1) == 0) ? mat[sx--][sy++] : mat[sx++][sy--];
            }
        }
        return ans;
    }
}
