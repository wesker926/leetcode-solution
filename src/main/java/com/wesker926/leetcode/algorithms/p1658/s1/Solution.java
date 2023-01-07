package com.wesker926.leetcode.algorithms.p1658.s1;

/**
 * @author wesker.gh
 * @date 2023/1/7
 * @description 双指针滑动窗口
 * 前缀后缀窗口
 */
public class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length, sum = 0, ans = n;
        for (int num : nums) {
            sum += num;
        }
        if (sum <= x) {
            return sum < x ? -1 : ans;
        }
        for (int i = n - 1, j = n; sum <= x || i >= 0; ) {
            if (sum > x) {
                sum -= nums[i--];
                continue;
            }
            if (sum == x) {
                ans = Math.min(ans, i + 1 + n - j);
            }
            sum += nums[--j];
        }
        return ans == n ? -1 : ans;
    }
}
