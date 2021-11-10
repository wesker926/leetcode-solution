package com.wesker926.leetcode.algorithms.p0495.s1;

/**
 * @author wesker.gh
 * @date 2021/11/10
 * @description 遍历
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            sum += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return sum + duration;
    }
}
