package com.wesker926.leetcode.algorithms.p0478.s1;

/**
 * @author wesker.gh
 * @date 2022/6/5
 * @description 随机xy + 拒绝采样
 */
public class Solution {

    private final double r;

    private final double cx;

    private final double cy;

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.cx = x_center;
        this.cy = y_center;
    }

    public double[] randPoint() {
        for (; ; ) {
            double rx = Math.random() * 2 * this.r - this.r;
            double ry = Math.random() * 2 * this.r - this.r;
            if (rx * rx + ry * ry <= this.r * this.r) {
                return new double[]{rx + this.cx, ry + this.cy};
            }
        }
    }
}
