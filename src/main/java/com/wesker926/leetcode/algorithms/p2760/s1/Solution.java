package com.wesker926.leetcode.algorithms.p2760.s1;

/**
 * @author wesker.gh
 * @date 2023/11/16
 * @description 双指针
 */
public class Solution {
    public int longestAlternatingSubarray(int[] nums, int t) {
        int ans = 0, n = nums.length;
        for (int i = 0, j; i < n; i++) {
            if ((nums[i] & 1) != 0 || nums[i] > t) continue;
            for (j = i; j + 1 < n && nums[j + 1] <= t && (nums[j] & 1) != (nums[j + 1] & 1); j++) ;
            System.out.println(i + " " + j);
            ans = Math.max(ans, j - i + 1);
            i = j;
        }
        return ans;
    }
}
