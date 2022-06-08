package com.wesker926.leetcode.algorithms.p0001.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/4/2
 * @description MAP
 * 也可排序后双指针，参考主站-p0167
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, t; i < nums.length; i++) {
            if ((t = map.getOrDefault(target - nums[i], -1)) >= 0) {
                return new int[]{t, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
