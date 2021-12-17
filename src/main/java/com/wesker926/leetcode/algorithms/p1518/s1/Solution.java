package com.wesker926.leetcode.algorithms.p1518.s1;

/**
 * @author wesker.gh
 * @date 2021/12/17
 * @description 模拟
 */
public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles, d = 0, m = 0;
        while (numBottles >= numExchange) {
            d = numBottles / numExchange;
            m = numBottles - d * numExchange;
            ans += d;
            numBottles = d + m;
        }
        return ans;
    }
}
