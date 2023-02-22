package com.wesker926.leetcode.algorithms.p1140.s1;

/**
 * @author wesker.gh
 * @date 2023/2/22
 * @description 记忆化搜索
 * 效果更好
 */
public class Solution {

    private final int[] MEM = new int[20000];

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] aft = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            aft[i] = aft[i + 1] + piles[i];
        }
        return dfs(aft, n, 0, 1);
    }

    private int dfs(int[] aft, int n, int st, int m) {
        int key = st * 200 + m;
        if (MEM[key] != 0) {
            return MEM[key];
        }

        if (st + m * 2 >= n) {
            MEM[key] = aft[st];
        } else {
            int cur = 0;
            for (int i = 1; i <= m * 2; i++) {
                cur = Math.max(cur, aft[st] - dfs(aft, n, st + i, Math.max(m, i)));
            }
            MEM[key] = cur;
        }
        return MEM[key];
    }
}
