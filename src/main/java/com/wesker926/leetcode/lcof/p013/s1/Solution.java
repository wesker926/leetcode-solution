package com.wesker926.leetcode.lcof.p013.s1;

/**
 * @author wesker.gh
 * @date 2022/3/30
 * @description DFS 注：不符合的点标记visit可省去compute
 */
public class Solution {
    public int movingCount(int m, int n, int k) {
        return dfs(new boolean[m][n], 0, 0, k);
    }

    private int dfs(boolean[][] visit, int x, int y, int k) {
        if (x < 0 || x >= visit.length || y < 0 || y >= visit[0].length || visit[x][y]) {
            return 0;
        }

        visit[x][y] = true;
        if (compute(x) + compute(y) > k) {
            return 0;
        }
        return 1 + dfs(visit, x - 1, y, k) + dfs(visit, x, y - 1, k) + dfs(visit, x + 1, y, k) + dfs(visit, x, y + 1, k);
    }

    private int compute(int i) {
        int r = 0;
        while (i != 0) {
            r += i % 10;
            i /= 10;
        }
        return r;
    }
}
