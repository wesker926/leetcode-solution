package com.wesker926.leetcode.algorithms.p1779.s1;

/**
 * @author wesker.gh
 * @date 2022/12/1
 * @description 遍历
 */
public class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] != x && points[i][1] != y) {
                continue;
            }
            int cur = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
            if (cur < min) {
                min = cur;
                ans = i;
            }
        }
        return ans;
    }
}
