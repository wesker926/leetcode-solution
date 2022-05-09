package com.wesker926.leetcode.algorithms.p0090.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/9
 * @description 排序 + DFS
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return dfs(new LinkedList<>(), new LinkedList<>(), nums, 0, false);
    }

    private List<List<Integer>> dfs(List<List<Integer>> ans, LinkedList<Integer> cur, int[] nums, int idx, boolean pre) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(cur));
            return ans;
        }

        dfs(ans, cur, nums, idx + 1, false);
        if (idx == 0 || nums[idx] != nums[idx - 1] || pre) {
            cur.add(nums[idx]);
            dfs(ans, cur, nums, idx + 1, true);
            cur.removeLast();
        }
        return ans;
    }
}
