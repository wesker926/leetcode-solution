package com.wesker926.leetcode.igc.p17_19.s1;

/**
 * @author wesker.gh
 * @date 2022/9/26
 * @description 原地hash
 * 还有异或解法，求和解法
 */
public class Solution {
    public int[] missingTwo(int[] nums) {
        int len = nums.length, idx = 0;
        int[] ans = new int[]{len + 1, len + 2};
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len) {
                nums[num - 1] = -nums[num - 1];
            } else if (num == len + 1) {
                ans[0] = 0;
            } else {
                ans[1] = 0;
            }
        }
        if (ans[0] != 0 && ans[1] != 0) {
            return ans;
        } else if (ans[0] != 0 || ans[1] != 0) {
            idx = 1;
            if (ans[1] != 0) {
                ans[0] = ans[1];
            }
        }
        for (int i = 0; i < len && idx < 2; i++) {
            if (nums[i] > 0) {
                ans[idx++] = i + 1;
            }
        }
        return ans;
    }
}
