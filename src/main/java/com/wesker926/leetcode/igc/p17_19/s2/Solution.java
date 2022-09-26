package com.wesker926.leetcode.igc.p17_19.s2;

/**
 * @author wesker.gh
 * @date 2022/9/26
 * @description 异或
 * 转换为只出现一次的数（两个）
 */
public class Solution {
    public int[] missingTwo(int[] nums) {
        int len = nums.length, n = len + 2, xor = (len + 1) ^ (len + 2);
        for (int i = 0; i < len; i++) {
            xor ^= (i + 1) ^ nums[i];
        }
        int lowBit = xor & (-xor);
        int[] ans = new int[2];
        for (int num : nums) {
            append(num, lowBit, ans);
        }
        for (int i = 1; i <= n; i++) {
            append(i, lowBit, ans);
        }
        return ans;
    }

    private void append(int num, int lowBit, int[] ans) {
        if ((num & lowBit) == 0) {
            ans[0] ^= num;
        } else {
            ans[1] ^= num;
        }
    }
}
