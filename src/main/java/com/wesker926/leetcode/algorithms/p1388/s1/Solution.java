package com.wesker926.leetcode.algorithms.p1388.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/8/18
 * @description DP
 * 打家劫舍高级版
 * 还有NlogN的贪心解法（堆）：https://leetcode.cn/problems/pizza-with-3n-slices/solutions/163281/shuang-xiang-lian-biao-tan-xin-suan-fa-shi-jian-fu/
 */
public class Solution {
    public int maxSizeSlices(int[] slices) {
        int ans = -1;
        for (int i = 0; i < 2; i++) {
            int[] arr = new int[slices.length - 1];
            System.arraycopy(slices, i, arr, 0, slices.length - 1);
            ans = Math.max(ans, dp(arr));
        }
        return ans;
    }

    private int dp(int[] arr) {
        int n = arr.length, k = (n + 1) / 3;
        int[][] dp = new int[3][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
            row[0] = 0;
        }
        for (int num : arr) {
            for (int j = 1; j <= k; j++) {
                dp[2][j] = Math.max(dp[1][j], dp[0][j - 1] + num);
            }
            int[] t = dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = t;
        }
        return dp[1][k];
    }
}
