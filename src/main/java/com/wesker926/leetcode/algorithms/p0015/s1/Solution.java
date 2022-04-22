package com.wesker926.leetcode.algorithms.p0015.s1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/22
 * @description 排序 + 三指针
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return ans;
        }
        for (int i = 0, n = nums.length; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[n - 1] + nums[n - 2] < 0) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            for (int j = i + 1, k = n - 1; j < k; ) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}
