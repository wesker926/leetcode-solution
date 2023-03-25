package com.wesker926.leetcode.algorithms.p2395.s1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2023/3/26
 * @description 哈希
 * 两数之和二元逆推定番，遍历 + 哈希
 */
public class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (!seen.add(nums[i] + nums[i + 1])) {
                return true;
            }
        }
        return false;
    }
}
