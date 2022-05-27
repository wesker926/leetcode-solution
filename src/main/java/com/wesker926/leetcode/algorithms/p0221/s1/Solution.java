package com.wesker926.leetcode.algorithms.p0221.s1;

/**
 * @author wesker.gh
 * @date 2022/5/27
 * @description DP
 * 进阶问题：主站-p0085
 * 注意入参是char，以及返回的是面积。
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[] dp = new int[n + 1];
        for (int i = m - 1; i >= 0; i--) {
            int pre = 0;
            for (int j = n - 1; j >= 0; j--) {
                int cur = matrix[i][j] == '0' ? 0 : 1 + Math.min(pre, Math.min(dp[j], dp[j + 1]));
                pre = dp[j];
                dp[j] = cur;
                ans = Math.max(ans, cur);
            }
        }
        return ans * ans;
    }
}
