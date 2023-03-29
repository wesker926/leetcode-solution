package com.wesker926.leetcode.algorithms.p1641.s1;

/**
 * @author wesker.gh
 * @date 2023/3/29
 * @description DP
 * 这里DP和官解语义不同，dp[i]是可以有(i+1)种选择的arr[i]的前缀和pre[i]
 */
public class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[4] - dp[3];
    }
}
