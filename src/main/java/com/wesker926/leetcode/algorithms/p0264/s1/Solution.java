package com.wesker926.leetcode.algorithms.p0264.s1;

/**
 * @author wesker.gh
 * @date 2022/6/14
 * @description DP + 记忆化
 */
public class Solution {

    private static int max = 1;

    private static final int[] NUM = new int[1700];

    private static final int[][] CACHE = new int[3][1700];

    private static final int[] FACTOR = new int[]{2, 3, 5};

    static {
        NUM[0] = 1;
    }

    public int nthUglyNumber(int n) {
        for (; max < n; max++) {
            NUM[max] = Integer.MAX_VALUE;
            for (int i = 0; i < CACHE.length; i++) {
                NUM[max] = Math.min(NUM[max], NUM[CACHE[i][max - 1]] * FACTOR[i]);
            }
            for (int i = 0; i < CACHE.length; i++) {
                CACHE[i][max] = CACHE[i][max - 1];
                if (NUM[CACHE[i][max - 1]] * FACTOR[i] == NUM[max]) {
                    CACHE[i][max]++;
                }
            }
        }
        return NUM[n - 1];
    }
}
