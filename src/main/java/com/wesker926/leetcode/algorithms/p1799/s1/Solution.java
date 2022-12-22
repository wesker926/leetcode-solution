package com.wesker926.leetcode.algorithms.p1799.s1;

/**
 * @author wesker.gh
 * @date 2022/12/22
 * @description DP + 状态压缩
 * 首先，贪心是错的，最大的公约数对应的两个数字可能能找到两个其他公约数是的最终结果更大
 * DP中，每个状态可以通过先前的状态转移而来，需要对当前状态的先前状态遍历
 * 时间复杂度O((2 ^ n) * (n ^ 2) + logC * (n ^ 2))，前面是DP的时间，后面是求GCD的时间
 */
public class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length, mask = (1 << n) - 1;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                grid[i][j] = gcd(nums[i], nums[j]);
            }
        }

        int[] dp = new int[mask + 1];
        for (int cur = 1; cur <= mask; cur++) {
            int count = Integer.bitCount(cur);
            if ((count & 1) != 0) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if (((cur >> i) & 1) == 0) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if (((cur >> j) & 1) == 0) {
                        continue;
                    }
                    dp[cur] = Math.max(dp[cur], dp[cur ^ (1 << i) ^ (1 << j)] + count / 2 * grid[i][j]);
                }
            }
        }
        return dp[mask];
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
