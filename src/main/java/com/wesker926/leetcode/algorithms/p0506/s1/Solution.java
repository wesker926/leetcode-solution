package com.wesker926.leetcode.algorithms.p0506.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2021/12/2
 * @description 排序
 */
public class Solution {

    private static final String[] TEXTS = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};

    public String[] findRelativeRanks(int[] score) {
        int[][] s = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            s[i] = new int[]{score[i], i};
        }

        Arrays.sort(s, (o1, o2) -> o2[0] - o1[0]);

        String[] r = new String[s.length];
        for (int i = 0; i < TEXTS.length && i < s.length; i++) {
            r[s[i][1]] = TEXTS[i];
        }
        for (int i = TEXTS.length; i < s.length; i++) {
            r[s[i][1]] = String.valueOf(i + 1);
        }
        return r;
    }
}
