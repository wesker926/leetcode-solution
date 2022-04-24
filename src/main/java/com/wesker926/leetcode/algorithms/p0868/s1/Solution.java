package com.wesker926.leetcode.algorithms.p0868.s1;

/**
 * @author wesker.gh
 * @date 2022/4/24
 * @description lowBit写法
 */
public class Solution {
    public int binaryGap(int n) {
        int ans = 0, high = n & -n, low;
        for (n -= high; n > 0; n -= high) {
            low = high;
            high = n & -n;
            ans = Math.max(ans, getGap(high, low));
        }
        return ans;
    }

    private int getGap(int high, int low) {
        int gap = 0;
        for (; high > low; high >>= 1, gap++) {
        }
        return gap;
    }
}
