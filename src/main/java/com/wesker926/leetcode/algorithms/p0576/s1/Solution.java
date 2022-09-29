package com.wesker926.leetcode.algorithms.p0576.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/9/29
 * @description DFS（记忆化搜索）
 * 还可以DP
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    private static final int[][] DIRS = new int[][]{{0, 1}, {0, -1,}, {1, 0}, {-1, 0}};

    private Map<Integer, Integer> memory;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memory = new HashMap<>();
        return dfs(m, n, maxMove, startRow, startColumn);
    }

    private int dfs(int m, int n, int c, int x, int y) {
        boolean inBound = inBound(m, n, x, y);
        if (c == 0 || !inBound) {
            return inBound ? 0 : 1;
        }
        int key = getKey(c, x, y), cur = memory.getOrDefault(key, -1);
        if (cur >= 0) {
            return cur;
        }
        cur = 0;
        for (int[] dir : DIRS) {
            cur = (cur + dfs(m, n, c - 1, x + dir[0], y + dir[1])) % MOD;
        }
        memory.put(key, cur);
        return cur;
    }

    private boolean inBound(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private int getKey(int c, int x, int y) {
        return (c << 12) | (x << 6) | y;
    }
}
