package com.wesker926.leetcode.algorithms.p0052.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description 回溯
 */
public class Solution {

    // 仅需检查上半区域
    private static final int[][] STEPS = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}};

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        return dfs(board, 0);
    }

    private int dfs(char[][] board, int row) {
        if (row == board.length) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                ans += dfs(board, row + 1);
                board[row][i] = '.';
            }
        }
        return ans;
    }

    private boolean isValid(char[][] board, int x, int y) {
        for (int[] step : STEPS) {
            for (int nx = x, ny = y; nx >= 0 && nx < board.length
                    && ny >= 0 && ny < board.length; nx += step[0], ny += step[1]) {
                if (board[nx][ny] != '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
