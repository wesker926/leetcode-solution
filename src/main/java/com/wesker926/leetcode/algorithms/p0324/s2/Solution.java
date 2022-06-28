package com.wesker926.leetcode.algorithms.p0324.s2;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/6/28
 * @description 排序 + 穿插
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length, half = (n + 1) / 2;
        Arrays.sort(nums);
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);
        for (int i = 0; half - 1 - i >= 0; i++) {
            nums[i * 2] = copy[half - 1 - i];
        }
        for (int i = 0; n - 1 - i >= half; i++) {
            nums[i * 2 + 1] = copy[n - 1 - i];
        }
    }
}
