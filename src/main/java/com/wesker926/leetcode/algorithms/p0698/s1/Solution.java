package com.wesker926.leetcode.algorithms.p0698.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/9/20
 * @description 状态压缩 + 记忆化搜索
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        sum /= k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > sum) {
            return false;
        }
        int state = (1 << nums.length) - 1;
        boolean[] visited = new boolean[state + 1];
        return dfs(nums, visited, sum, state, 0);
    }

    private boolean dfs(int[] nums, boolean[] visited, int part, int state, int cur) {
        if (state == 0) {
            return true;
        }
        if (visited[state]) {
            return false;
        }
        visited[state] = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + cur > part) {
                break;
            }
            if ((state & (1 << i)) == 0) {
                continue;
            }
            if (dfs(nums, visited, part, state ^ (1 << i), (cur + nums[i]) % part)) {
                return true;
            }
        }
        return false;
    }
}
