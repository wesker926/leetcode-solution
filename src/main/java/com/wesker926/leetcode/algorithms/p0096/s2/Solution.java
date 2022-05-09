package com.wesker926.leetcode.algorithms.p0096.s2;

/**
 * @author wesker.gh
 * @date 2022/5/9
 * @description DP
 * dp[i]表示数量为i的树的个数，由不同的左子树数量*右子树数量累加而得。
 */
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
