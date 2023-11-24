package com.wesker926.leetcode.algorithms.p2824.s1;

import java.util.Collections;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/11/24
 * @description 排序 + 双指针
 */
public class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        Collections.sort(nums);
        for (int i = 0, j = nums.size() - 1; i < j; i++) {
            while (i < j && nums.get(i) + nums.get(j) >= target) j--;
            ans += j - i;
        }
        return ans;
    }
}
