package com.wesker926.leetcode.algorithms.p0891.s2;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/11/18
 * @description 数学
 * 计算每个数作为max和min的贡献
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long pow = 1, maxSum = 0, minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSum = (maxSum + nums[i] * pow) % MOD;
            minSum = (minSum + nums[nums.length - 1 - i] * pow) % MOD;
            pow = (pow << 1) % MOD;
        }
        return (int) ((maxSum - minSum + MOD) % MOD);
    }
}
