package com.wesker926.leetcode.algorithms.p0060.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description 数学
 */
public class Solution {
    public String getPermutation(int n, int k) {
        int[] canUse = new int[9];
        Arrays.fill(canUse, 1);
        StringBuilder sb = new StringBuilder();
        k--;
        for (int f = factorial(n); n > 0; n--) {
            f /= n;
            for (int c = k / f, i = 0; i < canUse.length; i++) {
                c -= canUse[i];
                if (c < 0) {
                    sb.append(i + 1);
                    canUse[i] = 0;
                    break;
                }
            }
            k %= f;
        }
        return sb.toString();
    }

    private int factorial(int n) {
        int ans = 1;
        while (n > 0) {
            ans *= n--;
        }
        return ans;
    }
}
