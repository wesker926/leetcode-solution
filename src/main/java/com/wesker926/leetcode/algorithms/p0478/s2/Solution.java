package com.wesker926.leetcode.algorithms.p0478.s2;

/**
 * @author wesker.gh
 * @date 2022/6/5
 * @description 累积分布函数
 * 概率密度函数 PDF f(r) = 2r
 * 累积分布函数 CDF f(r) = r2
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
        double rr = Math.sqrt(Math.random()) * this.r;
        double ra = Math.random() * 2 * Math.PI;
        return new double[]{rr * Math.cos(ra) + this.cx, rr * Math.sin(ra) + this.cy};
    }
}
