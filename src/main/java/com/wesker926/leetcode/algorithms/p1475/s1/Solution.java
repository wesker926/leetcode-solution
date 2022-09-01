package com.wesker926.leetcode.algorithms.p1475.s1;

/**
 * @author wesker.gh
 * @date 2022/9/1
 * @description 单调栈
 */
public class Solution {
    public int[] finalPrices(int[] prices) {
        int[] stack = new int[prices.length];
        for (int i = 0, idx = 0; i < prices.length; i++) {
            while (idx != 0 && prices[stack[idx - 1]] >= prices[i]) {
                prices[stack[--idx]] -= prices[i];
            }
            stack[idx++] = i;
        }
        return prices;
    }
}
