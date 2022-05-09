package com.wesker926.leetcode.algorithms.p0096.s1;

/**
 * @author wesker.gh
 * @date 2022/5/9
 * @description DP
 * dp(i)表示长度为i+1的右子树链的数量的右前缀和
 */
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j > 0; j--) {
                dp[j] = dp[j - 1] + dp[j + 1];
            }
            dp[0] += dp[1];
        }
        return dp[0];
    }
}
