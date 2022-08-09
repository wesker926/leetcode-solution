package com.wesker926.leetcode.algorithms.p1413.s1;

/**
 * @author wesker.gh
 * @date 2022/8/9
 * @description 贪心
 * 找最小前缀和
 */
public class Solution {
    public int minStartValue(int[] nums) {
        int min = nums[0], sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return Math.max(1, 1 - min);
    }
}
