package com.wesker926.leetcode.algorithms.p1403.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/8/4
 * @description 排序 + 贪心
 */
public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int add = 0, idx = nums.length - 1; add <= sum >> 1; idx--) {
            ans.add(nums[idx]);
            add += nums[idx];
        }
        return ans;
    }
}
