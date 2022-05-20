package com.wesker926.leetcode.algorithms.p0123.s1;

/**
 * @author wesker.gh
 * @date 2022/5/20
 * @description DP
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int buy1, buy2, sell1, sell2;
        buy1 = buy2 = -prices[0];
        sell1 = sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
