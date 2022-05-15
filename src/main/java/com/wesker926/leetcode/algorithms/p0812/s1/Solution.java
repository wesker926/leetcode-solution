package com.wesker926.leetcode.algorithms.p0812.s1;

/**
 * @author wesker.gh
 * @date 2022/5/15
 * @description 遍历 + 叉积
 */
public class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    private double area(int[] a, int[] b, int[] c) {
        return 0.5 * Math.abs((a[0] - c[0]) * (b[1] - c[1]) - (b[0] - c[0]) * (a[1] - c[1]));
    }
}
