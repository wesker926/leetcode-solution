package com.wesker926.leetcode.algorithms.p1235.s1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wesker.gh
 * @date 2022/10/22
 * @description DP
 * dp[i] = max(dp[i - 1], dp[pre] + profit[i])
 */
public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] arr = new int[startTime.length][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[binary(arr, i, arr[i][0]) + 1] + arr[i][2]);
        }
        return dp[arr.length];
    }

    private int binary(int[][] arr, int i, int t) {
        int l = 0, r = i - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m][1] <= t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}
