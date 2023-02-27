package com.wesker926.leetcode.algorithms.p1144.s1;

/**
 * @author wesker.gh
 * @date 2023/2/27
 * @description 贪心
 * 奇一个偶一个取最小的
 */
public class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            ans[i & 1] += Math.max(nums[i] - Math.min(i > 0 ? nums[i - 1] : 1001, i < n - 1 ? nums[i + 1] : 1001) + 1, 0);
        }
        return Math.min(ans[0], ans[1]);
    }
}
