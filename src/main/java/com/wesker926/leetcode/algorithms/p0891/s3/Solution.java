package com.wesker926.leetcode.algorithms.p0891.s3;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/11/18
 * @description 数学
 * 设B(j) = sum((num[j] - num[i]) * 2 ^ (j - i - 1)) = num[j] * (2 ^ j - 1) - sum(num[i] * 2 ^ (j - i - 1))
 * 设x(j) = sum(num[i] * 2 ^ (j - i - 1))，则x(j + 1) = 2 * x(j) + num[j]
 * 设y(j) = 2 ^ j，则y(j + 1) = y(j) * 2
 * 则B(j + 1) = num[j + 1] * (y(j + 1) - 1) - x(j + 1)
 * ans = sum(B(j))
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long ans = 0, x = nums[0], y = 2;
        for (int j = 1; j < nums.length; j++) {
            ans = (ans + nums[j] * (y - 1) - x) % MOD;
            x = ((x << 1) + nums[j]) % MOD;
            y = (y << 1) % MOD;
        }
        return (int) ((ans + MOD) % MOD);
    }
}
