package com.wesker926.leetcode.algorithms.p0121.s1;

/**
 * @author wesker.gh
 * @date 2022/5/20
 * @description 遍历（找最大正差值）
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, min = prices[0];
        for (int price : prices) {
            min = Math.min(min, price);
            ans = Math.max(ans, price - min);
        }
        return ans;
    }
}
