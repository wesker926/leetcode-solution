package com.wesker926.leetcode.algorithms.p0164.s1;

/**
 * @author wesker.gh
 * @date 2022/6/2
 * @description 基数排序（桶排序）
 * 基数排序的时间复杂度为O(nlog(m,max))
 * 注：下列实现中3 * log(10,max) + 1最大为31
 * 而log(n)最大也为31
 * 实际上整形范围内跟nlog(n)的快排基本没差距
 */
public class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] copy = new int[n];
        for (long exp = 1; max >= exp; exp *= 10) {
            int[] bucket = new int[10];
            for (int num : nums) {
                bucket[(num / (int) exp) % 10]++;
            }
            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                copy[--bucket[(nums[i] / (int) exp) % 10]] = nums[i];
            }
            System.arraycopy(copy, 0, nums, 0, n);
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(nums[i] - nums[i - 1], res);
        }
        return res;
    }
}
