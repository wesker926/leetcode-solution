package com.wesker926.leetcode.algorithms.p0051.s1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description 回溯
 */
public class Solution {

    // 仅需检查上半区域
    private static final int[][] STEPS = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}};

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new LinkedList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(ans, board, 0);
        return ans;
    }

    private void dfs(List<List<String>> ans, char[][] board, int row) {
        if (row == board.length) {
            List<String> temp = new LinkedList<>();
            for (char[] cs : board) {
                temp.add(new String(cs));
            }
            ans.add(temp);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                dfs(ans, board, row + 1);
                board[row][i] = '.';
            }
        }
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
