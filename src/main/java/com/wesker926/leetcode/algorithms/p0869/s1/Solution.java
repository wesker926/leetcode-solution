package com.wesker926.leetcode.algorithms.p0869.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2021/10/28
 * @description dfs
 */
public class Solution {
    public boolean reorderedPowerOf2(int n) {
        if ((n & (n - 1)) == 0) {
            return true;
        }

        List<Integer> nums = new ArrayList<>();
        for (; n != 0; n /= 10) {
            nums.add(n % 10);
        }

        return dfs(nums, 0);
    }

    private boolean dfs(List<Integer> nums, int start) {
        if (start >= nums.size()) {
            return check(nums);
        }

        for (int i = start; i < nums.size(); i++) {
            if (start == 0 && nums.get(i) == 0) {
                continue;
            }

            if (start != i && nums.get(start) == nums.get(i)) {
                continue;
            }

            swap(nums, start, i);
            if (dfs(nums, start + 1)) {
                return true;
            }
            swap(nums, start, i);
        }
        return false;
    }

    private void swap(List<Integer> nums, int i, int j) {
        int t = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, t);
    }

    private boolean check(List<Integer> nums) {
        int n = 0, m = 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            n += nums.get(i) * m;
            m *= 10;
        }

        return (n & (n - 1)) == 0;
    }
}
