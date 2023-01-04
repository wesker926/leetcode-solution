package com.wesker926.leetcode.algorithms.p1802.s1;

/**
 * @author wesker.gh
 * @date 2023/1/4
 * @description 贪心 + 二分
 * sum = (val - left + val - 1) * left / 2 + (val - right + val - 1) * right / 2 + (n - left - right - 1) + val
 * 有数学推导解法：https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/solutions/2042360/you-jie-shu-zu-zhong-zhi-ding-xia-biao-c-aav4/
 */
public class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long l = 1, r = maxSum, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(m, n, index, maxSum)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (int) r;
    }

    private boolean check(long val, int n, int idx, int max) {
        long left = Math.min(val - 1, idx), right = Math.min(val - 1, n - idx - 1);
        long sum = val * (left + right + 1) - (left + 3) * left / 2 - (right + 3) * right / 2 + (n - 1);
        return sum <= max;
    }
}
