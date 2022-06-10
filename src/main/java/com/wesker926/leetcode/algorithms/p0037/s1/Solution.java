package com.wesker926.leetcode.algorithms.p0037.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/28
 * @description DFS + 位运算优化 + 预填优化
 */
public class Solution {

    private int[][] cache;

    private List<int[]> spaces;

    public void solveSudoku(char[][] board) {
        cache = new int[3][9];
        spaces = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0, k; j < 9; j++) {
                if (board[i][j] != '.') {
                    k = (i / 3) * 3 + j / 3;
                    flip(i, j, k, board[i][j] - '1');
                }
            }
        }

        boolean isModify = true;
        while (isModify) {
            isModify = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0, k; j < 9; j++) {
                    if (board[i][j] != '.') {
                        continue;
                    }
                    k = (i / 3) * 3 + j / 3;
                    int canFill = ~(cache[0][i] | cache[1][j] | cache[2][k]) & 0x1ff;
                    if ((canFill & (canFill - 1)) == 0) {
                        canFill = Integer.bitCount(canFill - 1);
                        board[i][j] = (char) (canFill + '1');
                        flip(i, j, k, canFill);
                        isModify = true;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0, k; j < 9; j++) {
                if (board[i][j] == '.') {
                    k = (i / 3) * 3 + j / 3;
                    spaces.add(new int[]{i, j, k});
                }
            }
        }
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int idx) {
        if (idx == spaces.size()) {
            return true;
        }

        int[] space = spaces.get(idx);
        int canFill = ~(cache[0][space[0]] | cache[1][space[1]] | cache[2][space[2]]) & 0x1ff;
        for (; canFill != 0; canFill &= canFill - 1) {
            int digit = Integer.bitCount((canFill & (-canFill)) - 1);
            board[space[0]][space[1]] = (char) (digit + '1');
            flip(space[0], space[1], space[2], digit);
            if (dfs(board, idx + 1)) {
                return true;
            }
            flip(space[0], space[1], space[2], digit);
        }
        return false;
    }

    private void flip(int i, int j, int k, int digit) {
        cache[0][i] ^= 1 << digit;
        cache[1][j] ^= 1 << digit;
        cache[2][k] ^= 1 << digit;
    }
}
