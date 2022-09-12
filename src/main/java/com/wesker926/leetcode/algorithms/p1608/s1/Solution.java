package com.wesker926.leetcode.algorithms.p1608.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/9/12
 * @description 排序 + 倒序遍历
 */
public class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1, x = 0;
        for (; i >= 0; i--, x++) {
            if (nums[i] < x) {
                break;
            }
        }
        return x <= nums[i + 1] ? x : -1;
    }
}
