package com.wesker926.leetcode.algorithms.p0268.s3;

/**
 * @author wesker.gh
 * @date 2021/11/6
 * @description 求和公式
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i : nums) {
            sum += i;
        }
        return n * (n + 1) / 2 - sum;
    }
}
