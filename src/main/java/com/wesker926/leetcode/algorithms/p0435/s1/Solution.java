package com.wesker926.leetcode.algorithms.p0435.s1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wesker.gh
 * @date 2022/6/24
 * @description DP
 * O(nlogn)非最优
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int[] dp = new int[n + 1];
        for (int i = 0, j; i < n; i++) {
            j = binary(intervals, i, intervals[i][0]);
            dp[i + 1] = Math.min(dp[i] + 1, dp[j] + i - j);
        }
        return dp[n];
    }

    private int binary(int[][] arr, int ed, int t) {
        int l = 0, r = ed, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m][1] <= t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
