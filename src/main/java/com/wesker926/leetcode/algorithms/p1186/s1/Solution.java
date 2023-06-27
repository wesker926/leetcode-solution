package com.wesker926.leetcode.algorithms.p1186.s1;

/**
 * @author wesker.gh
 * @date 2023/6/27
 * @description DP
 * 不需要维护min
 */
public class Solution {
    public int maximumSum(int[] arr) {
        int dp1 = arr[0], dp2 = 0, ans = dp1;
        for (int i = 1; i < arr.length; i++) {
            dp2 = Math.max(dp2 + arr[i], dp1);
            dp1 = Math.max(dp1, 0) + arr[i];
            ans = Math.max(ans, Math.max(dp1, dp2));
        }
        return ans;
    }

    public int maximumSum1(int[] arr) {
        int dp1 = arr[0], dp2 = 0, min = dp1, ans = dp1;
        for (int i = 1; i < arr.length; i++) {
            int t = Math.min(min, arr[i]);
            min = dp1 >= 0 ? t : arr[i];
            dp2 = Math.max(dp2 + arr[i], dp1 + arr[i] - t);
            dp1 = Math.max(dp1, 0) + arr[i];
            ans = Math.max(ans, Math.max(dp1, dp2));
        }
        return ans;
    }
}
