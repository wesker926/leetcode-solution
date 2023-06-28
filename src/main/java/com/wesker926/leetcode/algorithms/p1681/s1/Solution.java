package com.wesker926.leetcode.algorithms.p1681.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/6/28
 * @description 预处理 + 状态压缩DP
 * 预处理为O(n * 2 ^ n)
 * 刷表法DP，每个元素有【未选，将选，已选】3种状态，因此DP为O(3 ^ n)
 * 这题也可以回溯，元素先排序，搞k个桶，挨个往里填
 */
public class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length, c = n / k, t = 1 << n;
        if (c == 1) return 0;
        int[] values = new int[t];
        Arrays.fill(values, -1);
        outer:
        for (int mask = 0; mask < t; mask++) {
            if (Integer.bitCount(mask) != c) continue;
            int[] table = new int[n + 1];
            int max = -1, min = n + 1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) continue;
                if (++table[nums[i]] > 1) continue outer;
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
            values[mask] = max - min;
        }
        int[] dp = new int[t];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < t; mask++) {
            if (dp[mask] == Integer.MAX_VALUE) continue;
            int flip = (t - 1) ^ mask, count = 0;
            boolean[] table = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                if ((flip & (1 << i)) != 0 && !table[nums[i]]) {
                    table[nums[i]] = true;
                    count++;
                }
            }
            if (count < c) continue;
            for (int sub = flip; sub > 0; sub = (sub - 1) & flip) {
                if (values[sub] > 0) dp[mask | sub] = Math.min(dp[mask | sub], dp[mask] + values[sub]);
            }
        }
        return dp[t - 1] == Integer.MAX_VALUE ? -1 : dp[t - 1];
    }
}
