package com.wesker926.leetcode.algorithms.s0001to0050.s0001;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2021/6/22
 * @description 1. 两数之和
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, t; i < nums.length; i++) {
            t = target - nums[i];
            if (map.containsKey(t)) {
                return new int[]{i, map.get(t)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
