package com.wesker926.leetcode.algorithms.p1037.s1;

/**
 * @author wesker.gh
 * @date 2022/6/8
 * @description 内积计算
 */
public class Solution {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[1][0] - points[0][0], y1 = points[1][1] - points[0][1];
        int x2 = points[2][0] - points[0][0], y2 = points[2][1] - points[0][1];
        return (x1 * x1 + y1 * y1) * (x2 * x2 + y2 * y2) != Math.pow(x1 * x2 + y1 * y2, 2);
    }
}
