package com.wesker926.leetcode.algorithms.p1518.s2;

/**
 * @author wesker.gh
 * @date 2021/12/17
 * @description 数学
 */
public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles < numExchange ? numBottles : numBottles + 1 + (numBottles - numExchange) / (numExchange - 1);
    }
}
