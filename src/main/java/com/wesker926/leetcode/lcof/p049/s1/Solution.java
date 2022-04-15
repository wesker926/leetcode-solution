package com.wesker926.leetcode.lcof.p049.s1;

/**
 * @author wesker.gh
 * @date 2022/4/15
 * @description DP
 */
public class Solution {

    private static int idx;

    private static final int[] MEMORY;

    private static final int[] FACTOR;

    private static final int[][] IDX_MEMORY;

    static {
        MEMORY = new int[2000];
        FACTOR = new int[]{2,3,5};
        IDX_MEMORY = new int[3][2000];
        MEMORY[1] = IDX_MEMORY[0][1] = IDX_MEMORY[1][1] = IDX_MEMORY[2][1] = 1;
        idx = 2;
    }

    public int nthUglyNumber(int n) {
        for (; idx <= n; idx++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < FACTOR.length; j++) {
                min = Math.min(min, FACTOR[j] * MEMORY[IDX_MEMORY[j][idx-1]]);
            }
            MEMORY[idx] = min;
            for (int j = 0; j < FACTOR.length; j++) {
                IDX_MEMORY[j][idx] = IDX_MEMORY[j][idx-1];
                if (min == FACTOR[j] * MEMORY[IDX_MEMORY[j][idx-1]]) {
                    IDX_MEMORY[j][idx]++;
                }
            }
        }
        return MEMORY[n];
    }
}
