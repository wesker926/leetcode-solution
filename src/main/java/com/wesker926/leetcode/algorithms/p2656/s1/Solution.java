package com.wesker926.leetcode.algorithms.p2656.s1;

/**
 * @author wesker.gh
 * @date 2023/11/15
 * @description 贪心
 */
public class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);
        return (max * 2 + k - 1) * k / 2;
    }
}
