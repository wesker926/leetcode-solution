package com.wesker926.leetcode.algorithms.p0812.s2;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/5/15
 * @description Andrew凸包算法 + 双层遍历
 */
public class Solution {
    public double largestTriangleArea(int[][] points) {
        points = getHull(points);
        double ans = 0;
        for (int i = 0; i < points.length; i++) {
            double pre, cur;
            for (int j = i + 1, k = j + 1; j < points.length; j++) {
                for (pre = -1; k < points.length; k++, pre = cur) {
                    cur = 0.5 * Math.abs(cross(points[i], points[j], points[k]));
                    if (pre >= cur) {
                        break;
                    }
                }
                k--;
                ans = Math.max(ans, pre);
            }
        }
        return ans;
    }

    private int[][] getHull(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int[] stack = new int[n + 1];
        boolean[] bottomHullUsed = new boolean[n];
        int idx = 0;
        stack[idx++] = 0;

        for (int i = 1; i < n; i++) {
            while (idx > 1 && cross(points[stack[idx - 2]], points[stack[idx - 1]], points[i]) < 0) {
                bottomHullUsed[stack[--idx]] = false;
            }
            stack[idx++] = i;
            bottomHullUsed[i] = true;
        }
        int bottomSize = idx;
        for (int i = n - 2; i >= 0; i--) {
            if (bottomHullUsed[i]) {
                continue;
            }
            while (idx > bottomSize && cross(points[stack[idx - 2]], points[stack[idx - 1]], points[i]) < 0) {
                idx--;
            }
            stack[idx++] = i;
        }
        int[][] res = new int[idx - 1][];
        for (int i = 0; i < idx - 1; i++) {
            res[i] = points[stack[i]];
        }
        return res;
    }

    private int cross(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - b[1]) - (c[0] - b[0]) * (b[1] - a[1]);
    }
}
