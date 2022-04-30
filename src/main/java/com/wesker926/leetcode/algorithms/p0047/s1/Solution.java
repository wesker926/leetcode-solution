package com.wesker926.leetcode.algorithms.p0047.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/30
 * @description DFS回溯 + swap
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return dfs(new LinkedList<>(), nums, 0);
    }

    private List<List<Integer>> dfs(List<List<Integer>> ans, int[] nums, int idx) {
        if (idx == nums.length) {
            List<Integer> temp = new LinkedList<>();
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
            return ans;
        }

        boolean[] set = new boolean[21];
        for (int i = idx; i < nums.length; i++) {
            if (!set[nums[i] + 10]) {
                set[nums[i] + 10] = true;
                swap(nums, idx, i);
                dfs(ans, nums, idx + 1);
                swap(nums, idx, i);
            }
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
