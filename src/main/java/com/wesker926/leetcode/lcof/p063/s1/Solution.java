package com.wesker926.leetcode.lcof.p063.s1;

/**
 * @author wesker.gh
 * @date 2022/4/19
 * @description 遍历
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, min = Integer.MAX_VALUE;
        for (int price : prices) {
            ans = Math.max(ans, price - min);
            min = Math.min(min, price);
        }
        return ans;
    }
}
