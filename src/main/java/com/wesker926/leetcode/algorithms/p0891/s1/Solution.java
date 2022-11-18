package com.wesker926.leetcode.algorithms.p0891.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/11/18
 * @description 数学
 * 计算每个数作为max和min的贡献
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    private static final int[] POW2 = new int[100000];

    static {
        POW2[0] = 1;
        for (int i = 1; i < POW2.length; i++) {
            POW2[i] = (POW2[i - 1] * 2) % MOD;
        }
    }

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = (ans + nums[i] * (long) (POW2[i] - POW2[nums.length - 1 - i] + MOD)) % MOD;
        }
        return (int) ans;
    }
}
