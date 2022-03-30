package com.wesker926.leetcode.lcof.p012.s1;

/**
 * @author wesker.gh
 * @date 2022/3/30
 * @description DFS 注：也可不用visit，原地置换board
 */
public class Solution {

    private static final int[][] POS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] w = word.toCharArray();
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visit, w, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visit, char[] word, int x, int y, int idx) {
        if (idx == word.length) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word[idx] || visit[x][y]) {
            return false;
        }

        visit[x][y] = true;
        for (int[] p : POS) {
            if (dfs(board, visit, word, x + p[0], y + p[1], idx + 1)) {
                return true;
            }
        }
        visit[x][y] = false;
        return false;
    }
}
