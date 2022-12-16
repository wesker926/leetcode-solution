package com.wesker926.leetcode.algorithms.p1785.s1;

/**
 * @author wesker.gh
 * @date 2022/12/16
 * @description 上取整
 * 注意int溢出
 */
public class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (int) ((Math.abs(goal - sum) + limit - 1) / limit);
    }
}
