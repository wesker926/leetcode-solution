package com.wesker926.leetcode.algorithms.p0188.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/10/4
 * @description DP
 * 和只能交易两次类似
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k], sell = new int[k];
        Arrays.fill(buy, -prices[0]);
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0, pre = 0; j < k; j++) {
                buy[j] = (pre = Math.max(buy[j], pre - prices[i]));
                sell[j] = (pre = Math.max(sell[j], pre + prices[i]));
            }
        }
        return Math.max(sell[k - 1], 0);
    }
}
