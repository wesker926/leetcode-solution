package com.wesker926.leetcode.algorithms.p0980.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/8/4
 * @description 记忆化搜索 + 状态压缩
 */
public class Solution {

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private Map<Integer, Integer> memory;

    public int uniquePathsIII(int[][] grid) {
        memory = new HashMap<>();
        int m = grid.length, n = grid[0].length, si = 0, sj = 0, st = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 2) st |= 1 << (i * n + j);
                else if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                }
            }
        }
        return dp(grid, si, sj, st);
    }

    private int dp(int[][] grid, int i, int j, int st) {
        if (grid[i][j] == 2) return st == 0 ? 1 : 0;
        int m = grid.length, n = grid[0].length;
        int key = ((i * n + j) << (m * n)) + st;
        if (memory.containsKey(key)) return memory.get(key);
        int res = 0;
        for (int[] dir : DIRS) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && (st & (1 << (ni * n + nj))) > 0)
                res += dp(grid, ni, nj, st ^ (1 << (ni * n + nj)));
        }
        memory.put(key, res);
        return memory.get(key);
    }
}
