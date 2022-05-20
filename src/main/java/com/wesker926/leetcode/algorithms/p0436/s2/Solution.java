package com.wesker926.leetcode.algorithms.p0436.s2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wesker.gh
 * @date 2022/5/20
 * @description 排序 + 二分
 */
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[][] startSort = new int[intervals.length][];
        for (int i = 0; i < intervals.length; i++) {
            startSort[i] = new int[]{intervals[i][0], i};
        }
        Arrays.sort(startSort, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[intervals.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = binary(startSort, intervals[i][1]);
        }
        return ans;
    }

    private int binary(int[][] arr, int t) {
        int l = 0, r = arr.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m][0] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l < arr.length ? arr[l][1] : -1;
    }
}
