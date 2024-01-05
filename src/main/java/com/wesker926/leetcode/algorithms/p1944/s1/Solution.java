package com.wesker926.leetcode.algorithms.p1944.s1;

/**
 * @author wesker.gh
 * @date 2024/1/5
 * @description 单调栈
 */
public class Solution {
    public int[] canSeePersonsCount(int[] h) {
        int n = h.length, idx = 0;
        int[] r = new int[n], sk = new int[n];
        for (int i = 0; i < n; i++) {
            for (; idx > 0 && h[sk[idx - 1]] <= h[i]; idx--) r[sk[idx - 1]]++;
            if (idx > 0) r[sk[idx - 1]]++;
            sk[idx++] = i;
        }
        return r;
    }
}
