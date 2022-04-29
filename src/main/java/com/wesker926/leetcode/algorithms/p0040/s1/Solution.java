package com.wesker926.leetcode.algorithms.p0040.s1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/29
 * @description 回溯（相同的数字只能在前一个选中时才能选中）
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(new LinkedList<>(), candidates, new boolean[candidates.length], 0, target);
    }

    private List<List<Integer>> dfs(List<List<Integer>> ans, int[] nums, boolean[] used, int idx, int target) {
        if (target == 0) {
            List<Integer> cur = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    cur.add(nums[i]);
                }
            }
            ans.add(cur);
            return ans;
        }
        if (idx == nums.length) {
            return ans;
        }
        dfs(ans, nums, used, idx + 1, target);
        if ((idx == 0 || nums[idx - 1] != nums[idx] || used[idx - 1]) && (target >= nums[idx])) {
            used[idx] = true;
            dfs(ans, nums, used, idx + 1, target - nums[idx]);
        }
        used[idx] = false;
        return ans;
    }
}
