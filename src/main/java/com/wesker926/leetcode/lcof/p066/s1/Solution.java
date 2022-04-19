package com.wesker926.leetcode.lcof.p066.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/4/19
 * @description 遍历累乘
 */
public class Solution {
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        Arrays.fill(b, 1);
        for (int i = 0, j = a.length - 1, p1 = 1, p2 = 1; j >= 0; i++, j--) {
            b[i] *= p1;
            b[j] *= p2;
            p1 *= a[i];
            p2 *= a[j];
        }
        return b;
    }
}
