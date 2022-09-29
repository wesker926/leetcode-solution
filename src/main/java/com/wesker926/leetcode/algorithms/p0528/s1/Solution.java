package com.wesker926.leetcode.algorithms.p0528.s1;

/**
 * @author wesker.gh
 * @date 2022/9/29
 * @description 前缀和 + 二分
 */
public class Solution {

    private final int[] pre;

    public Solution(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int tar = (int) (Math.random() * pre[pre.length - 1]);
        int l = 0, r = pre.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (pre[m] <= tar) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
