package com.wesker926.leetcode.algorithms.p2022.s1;

/**
 * @author wesker.gh
 * @date 2022/1/1
 * @description 2022元旦快乐
 */
public class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] ans = new int[m][n];
        for (int i = 0, k = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[k++];
            }
        }
        return ans;
    }
}
