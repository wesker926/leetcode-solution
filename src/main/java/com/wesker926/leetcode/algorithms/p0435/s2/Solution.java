package com.wesker926.leetcode.algorithms.p0435.s2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wesker.gh
 * @date 2022/6/24
 * @description 贪心
 * O(nlogn)排序时间
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 1, right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
                count++;
            }
        }
        return n - count;
    }
}
