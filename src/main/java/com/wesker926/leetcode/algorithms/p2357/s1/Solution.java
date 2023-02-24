package com.wesker926.leetcode.algorithms.p2357.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/2/24
 * @description 排序
 */
public class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1], cnt = 0, sum = 0;
        for (int num : nums) {
            int cur = num - sum;
            if (cur <= 0) {
                continue;
            }
            cnt++;
            sum += cur;
            if (max == sum) {
                break;
            }
        }
        return cnt;
    }
}
