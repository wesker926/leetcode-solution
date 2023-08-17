package com.wesker926.leetcode.algorithms.p1444.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/8/17
 * @description 预处理 + 记忆化搜索
 * 直接DP应该也可以
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length();
        int[][][] memory = new int[m + 1][n][k + 1];
        for (int i = m - 1; i >= 0; i--) {
            int[] pre = new int[n + 1];
            for (int j = n - 1; j >= 0; j--) {
                pre[j] = pre[j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
            for (int j = 0; j < n; j++) {
                Arrays.fill(memory[i][j], -1);
                memory[i][j][0] = memory[i + 1][j][0] + pre[j];
            }
        }
        int ans = Math.max(dfs(m, n, 0, 0, k, memory), 0);
        System.out.println(Arrays.deepToString(memory));
        return ans;
    }

    private int dfs(int m, int n, int i, int j, int k, int[][][] memory) {
        if (memory[i][j][k] >= 0) return memory[i][j][k];
        if (memory[i][j][0] < k) return 0;
        if (k == 1) return 1;
        long ans = 0;
        for (int ni = i + 1; ni < m; ni++) {
            if (memory[i][j][0] - memory[ni][j][0] <= 0) continue;
            ans = (ans + dfs(m, n, ni, j, k - 1, memory)) % MOD;
        }
        for (int nj = j + 1; nj < n; nj++) {
            if (memory[i][j][0] - memory[i][nj][0] <= 0) continue;
            ans = (ans + dfs(m, n, i, nj, k - 1, memory)) % MOD;
        }
        memory[i][j][k] = (int) ans;
        return memory[i][j][k];
    }
}
