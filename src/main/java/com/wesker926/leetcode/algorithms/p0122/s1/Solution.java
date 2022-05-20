package com.wesker926.leetcode.algorithms.p0122.s1;

/**
 * @author wesker.gh
 * @date 2022/5/20
 * @description 贪心（所有正差值的和）
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
