package com.wesker926.leetcode.algorithms.p0497.s1;

/**
 * @author wesker.gh
 * @date 2022/6/9
 * @description 二分 + 前缀和
 * 计算面积前缀和，用二分找到随机点所属的矩形，然后计算该点的坐标
 */
public class Solution {

    private final int[][] rects;

    private final int[] areaPre;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.areaPre = new int[rects.length + 1];
        for (int i = 0; i < rects.length; i++) {
            areaPre[i + 1] = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1) + this.areaPre[i];
        }
    }

    public int[] pick() {
        int t = (int) (Math.random() * (this.areaPre[this.areaPre.length - 1]));
        int idx = binary(t + 1) - 1;
        t -= this.areaPre[idx];
        int[] rect = this.rects[idx];
        return new int[]{rect[0] + t % (rect[2] - rect[0] + 1), rect[1] + t / (rect[2] - rect[0] + 1)};
    }

    private int binary(int t) {
        int l = 0, r = this.areaPre.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (this.areaPre[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
