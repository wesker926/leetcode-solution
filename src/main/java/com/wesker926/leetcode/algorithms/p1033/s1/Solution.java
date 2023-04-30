package com.wesker926.leetcode.algorithms.p1033.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/4/30
 * @description 贪心
 */
public class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] nums = new int[]{a, b, c}, ans = new int[2];
        Arrays.sort(nums);
        ans[0] = (nums[0] + 1 == nums[1] ? 0 : 1) + (nums[1] + 1 == nums[2] ? 0 : 1);
        if (nums[0] + 2 == nums[1] || nums[1] + 2 == nums[2]) ans[0] = 1;
        ans[1] = nums[2] - nums[0] - 2;
        return ans;
    }

    public int[] numMovesStones1(int a, int b, int c) {
        int[] nums = {a, b, c}, ans = new int[2];
        Arrays.sort(nums);
        ans[1] = nums[2] - nums[0] - 2;
        int d1 = nums[1] - nums[0] - 1, d2 = nums[2] - nums[1] - 1;
        ans[0] = d1 == 0 && d2 == 0 ? 0 : (Math.min(d1, d2) < 2 ? 1 : 2);
        return ans;
    }
}
