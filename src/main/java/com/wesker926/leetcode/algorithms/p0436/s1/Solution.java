package com.wesker926.leetcode.algorithms.p0436.s1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wesker.gh
 * @date 2022/5/20
 * @description 排序 + 双指针
 */
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Integer[] startSort = new Integer[n];
        Integer[] endSort = new Integer[n];
        for (int i = 0; i < n; i++) {
            startSort[i] = endSort[i] = i;
        }
        Arrays.sort(startSort, Comparator.comparingInt(i -> intervals[i][0]));
        Arrays.sort(endSort, Comparator.comparingInt(i -> intervals[i][1]));
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0, j = 0; j < n; j++) {
            if (intervals[endSort[i]][1] <= intervals[startSort[j]][0]) {
                ans[endSort[i++]] = startSort[j--];
            }
        }
        return ans;
    }
}
