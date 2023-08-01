package com.wesker926.leetcode.algorithms.p2681.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/8/1
 * @description DP + 前缀和
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        long ans = 0, pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) pre = (pre * 2 + nums[i - 1]) % MOD;
            long factor = (((long) nums[i]) * nums[i]) % MOD;
            ans = (ans + (pre + nums[i]) * factor) % MOD;
        }
        return (int) ans;
    }
}
