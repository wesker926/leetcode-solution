package com.wesker926.leetcode.algorithms.p2050.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/7/28
 * @description 记忆化搜索
 * 也可用堆，但DP更优
 */
public class Solution {

    private int[] head, next, edge, time, dp;

    public int minimumTime(int n, int[][] relations, int[] time) {
        int m = relations.length;
        this.time = time;
        head = new int[n + 1];
        next = new int[m];
        edge = new int[m];
        dp = new int[n + 1];
        Arrays.fill(head, -1);
        for (int i = 0, idx = 0; i < m; i++) {
            next[idx] = head[relations[i][0]];
            head[relations[i][0]] = idx;
            edge[idx++] = relations[i][1];
            dp[relations[i][1]]++;
        }
        List<Integer> first = new ArrayList<>();
        for (int i = 1; i <= n; i++) if (dp[i] == 0) first.add(i);
        Arrays.fill(dp, 0);
        int ans = 0;
        for (int cur : first) ans = Math.max(ans, dfs(cur));
        return ans;
    }

    private int dfs(int cur) {
        if (dp[cur] != 0) return dp[cur];
        for (int i = head[cur]; i >= 0; i = next[i]) {
            dp[cur] = Math.max(dp[cur], dfs(edge[i]));
        }
        dp[cur] += time[cur - 1];
        return dp[cur];
    }
}
