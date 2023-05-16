package com.wesker926.leetcode.algorithms.p1335.s2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2023/5/16
 * @description DP + 单调栈
 * https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/solutions/2271103/gong-zuo-ji-hua-de-zui-di-nan-du-by-leet-dule/
 */
public class Solution {

    private static final int INF = Integer.MAX_VALUE / 2;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] dp = new int[2][n + 1];
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;
        LinkedList<int[]> stack = new LinkedList<>();
        for (int i = 1; i <= d; i++, stack.clear()) {
            for (int j = i; j <= n; j++) {
                int min = dp[0][j - 1];
                while (!stack.isEmpty() && jobDifficulty[stack.peek()[0] - 1] < jobDifficulty[j - 1]) {
                    min = Math.min(min, stack.pop()[1]);
                }
                dp[1][j] = Math.min(min + jobDifficulty[j - 1], stack.isEmpty() ? INF : dp[1][stack.peek()[0]]);
                stack.push(new int[]{j, min});
            }
            int[] t = dp[0];
            dp[0] = dp[1];
            dp[1] = t;
        }
        return dp[0][n];
    }
}
