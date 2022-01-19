package com.wesker926.leetcode.algorithms.p0219.s1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2022/1/19
 * @description 哈希表 + 滑动窗口
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0 || nums.length == 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            if (i - k >= 0) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
