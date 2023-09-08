package com.wesker926.leetcode.algorithms.p2651.s1;

/**
 * @author wesker.gh
 * @date 2023/9/8
 * @description 数学
 */
public class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
