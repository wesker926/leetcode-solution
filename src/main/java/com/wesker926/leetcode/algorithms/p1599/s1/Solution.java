package com.wesker926.leetcode.algorithms.p1599.s1;

/**
 * @author wesker.gh
 * @date 2023/3/5
 * @description 模拟
 * 粪题
 */
public class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (runningCost >= boardingCost * 4) {
            return -1;
        }
        int maxProfit = 0, curProfit = 0, ans = -1;
        for (int i = 1, customer = customers[0]; customer > 0 || i <= customers.length; i++) {
            int canTake = Math.min(customer, 4);
            customer -= canTake;
            if ((curProfit += boardingCost * canTake - runningCost) > maxProfit) {
                maxProfit = curProfit;
                ans = i;
            }
            if (i < customers.length) {
                customer += customers[i];
            }
        }
        return ans;
    }
}
