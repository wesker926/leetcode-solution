package com.wesker926.leetcode.algorithms.p0039.s1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/29
 * @description 回溯（按origin-num分层）
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(new LinkedList<>(), candidates, new int[candidates.length], 0, target);
    }

    private List<List<Integer>> dfs(List<List<Integer>> ans, int[] nums, int[] counts, int idx, int target) {
        if (target == 0) {
            List<Integer> cur = new LinkedList<>();
            for (int i = 0; i < idx; i++) {
                for (int j = 0; j < counts[i]; j++) {
                    cur.add(nums[i]);
                }
            }
            ans.add(cur);
            return ans;
        }
        if (idx == nums.length) {
            return ans;
        }
        for (int sum = 0; sum <= target; sum += nums[idx], counts[idx]++) {
            dfs(ans, nums, counts, idx + 1, target - sum);
        }
        counts[idx] = 0;
        return ans;
    }
}
