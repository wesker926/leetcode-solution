package com.wesker926.leetcode.algorithms.p0790.s2;

/**
 * @author wesker.gh
 * @date 2022/11/12
 * @description DP（矩阵快速幂）
 * 此DP状态转移可以映射为矩阵乘法
 * 矩阵乘法可以采用快速幂的方式加速为O(logN)
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int numTilings(int n) {
        if (n < 3) {
            return n;
        }
        int[][] a = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int[][] b = new int[][]{{0, 1, 2}, {1, 1, 0}, {0, 1, 1}};
        for (n -= 2; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                a = mulMatrix(a, b);
            }
            b = mulMatrix(b, b);
        }
        return mulMatrix(new int[][]{{1, 2, 2}}, a)[0][1];
    }

    private int[][] mulMatrix(int[][] a, int[][] b) {
        int m = a.length, n = b[0].length, x = a[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < x; k++) {
                    res[i][j] = (int) (((long) a[i][k] * b[k][j] + res[i][j]) % MOD);
                }
            }
        }
        return res;
    }
}
