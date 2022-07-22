package com.wesker926.leetcode.algorithms.p0757.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/7/22
 * @description 贪心
 * 主站-p0452的进阶版本（两个元素）
 * 注：S集合可以不连续
 * 注：只需要两个int，可省略栈空间开销
 */
public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> a1[0] != a2[0] ? a1[0] - a2[0] : a2[1] - a1[1]);
        int ans = 2, n = intervals.length, first = intervals[n - 1][0], second = intervals[n - 1][0] + 1;
        for (int i = n - 2; i >= 0; i--) {
            if (intervals[i][1] < first) {
                first = intervals[i][0];
                second = intervals[i][0] + 1;
                ans += 2;
            } else if (intervals[i][1] < second) {
                second = first;
                first = intervals[i][0];
                ans += 1;
            }
        }
        return ans;
    }
}
