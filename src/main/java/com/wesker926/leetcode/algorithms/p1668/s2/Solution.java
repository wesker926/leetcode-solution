package com.wesker926.leetcode.algorithms.p1668.s2;

/**
 * @author wesker.gh
 * @date 2022/11/3
 * @description DP
 * 这里可以用kmp算法优化，以后有时间写吧
 */
public class Solution {
    public int maxRepeating(String sequence, String word) {
        int m = word.length(), n = sequence.length();
        int[] dp = new int[n];
        for (int i = m - 1; i < n; i++) {
            boolean valid = true;
            for (int j = 0; j < m; j++) {
                if (word.charAt(j) != sequence.charAt(i - m + 1 + j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                dp[i] = (i < m ? 0 : dp[i - m]) + 1;
            }
        }
        int ans = 0;
        for (int cur : dp) {
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
