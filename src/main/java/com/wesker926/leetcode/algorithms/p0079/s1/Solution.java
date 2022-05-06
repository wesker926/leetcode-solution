package com.wesker926.leetcode.algorithms.p0079.s1;

/**
 * @author wesker.gh
 * @date 2022/5/6
 * @description DFS（回溯）
 */
public class Solution {

    private static final int[][] STEPS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        char[] cs = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visit, cs, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visit, char[] word, int idx, int x, int y) {
        if (word.length == idx) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word[idx] || visit[x][y]) {
            return false;
        }

        visit[x][y] = true;
        for (int[] step : STEPS) {
            if (dfs(board, visit, word, idx + 1, x + step[0], y + step[1])) {
                return true;
            }
        }
        visit[x][y] = false;
        return false;
    }
}
