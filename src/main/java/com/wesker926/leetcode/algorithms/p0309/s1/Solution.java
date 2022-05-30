package com.wesker926.leetcode.algorithms.p0309.s1;

/**
 * @author wesker.gh
 * @date 2022/5/30
 * @description DP
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0], empty = 0, preEmpty = 0;
        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, preEmpty - prices[i]);
            preEmpty = empty;
            empty = Math.max(empty, hold + prices[i]);
        }
        return empty;
    }
}
