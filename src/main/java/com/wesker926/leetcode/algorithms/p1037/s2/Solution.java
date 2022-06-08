package com.wesker926.leetcode.algorithms.p1037.s2;

/**
 * @author wesker.gh
 * @date 2022/6/8
 * @description 外积计算
 */
public class Solution {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[1][0] - points[0][0], y1 = points[1][1] - points[0][1];
        int x2 = points[2][0] - points[0][0], y2 = points[2][1] - points[0][1];
        return x1 * y2 - x2 * y1 != 0;
    }
}
