package com.wesker926.leetcode.algorithms.p0078.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/6
 * @description 回溯
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return backTracking(new LinkedList<>(), nums, new boolean[nums.length], 0);
    }

    private List<List<Integer>> backTracking(List<List<Integer>> ans, int[] nums, boolean[] select, int idx) {
        if (idx == nums.length) {
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (select[i]) {
                    temp.add(nums[i]);
                }
            }
            ans.add(temp);
            return ans;
        }
        backTracking(ans, nums, select, idx + 1);
        select[idx] = true;
        backTracking(ans, nums, select, idx + 1);
        select[idx] = false;
        return ans;
    }
}
