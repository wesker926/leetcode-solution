package com.wesker926.leetcode.algorithms.p2460.s1;

/**
 * @author wesker.gh
 * @date 2023/6/5
 * @description 遍历模拟
 */
public class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                nums[j] <<= 1;
                nums[j + 1] = 0;
            }
            if (nums[j] != 0) swap(nums, i++, j);
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
