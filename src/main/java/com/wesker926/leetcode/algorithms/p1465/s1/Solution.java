package com.wesker926.leetcode.algorithms.p1465.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/10/27
 * @description 贪心
 */
public class Solution {
    public int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
        Arrays.sort(hCuts);
        Arrays.sort(vCuts);
        int maxH = Math.max(hCuts[0], h - hCuts[hCuts.length - 1]), maxW = Math.max(vCuts[0], w - vCuts[vCuts.length - 1]);
        for (int i = 1; i < hCuts.length; i++) maxH = Math.max(maxH, hCuts[i] - hCuts[i - 1]);
        for (int i = 1; i < vCuts.length; i++) maxW = Math.max(maxW, vCuts[i] - vCuts[i - 1]);
        return (int) (((long) maxH * maxW) % (int) (1e9 + 7));
    }
}
