package com.wesker926.leetcode.algorithms.p0036.s1;

/**
 * @author wesker.gh
 * @date 2022/4/28
 * @description 遍历检查
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] cache = new int[3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0, k; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                k = (i / 3) * 3 + j / 3;
                if (!checkAndMark(cache, i, j, k, board[i][j] - '1')) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkAndMark(int[][] cache, int i, int j, int k, int digit) {
        int bit = 1 << digit;
        if ((cache[0][i] & bit) != 0 || (cache[1][j] & bit) != 0 || (cache[2][k] & bit) != 0) {
            return false;
        }
        cache[0][i] |= bit;
        cache[1][j] |= bit;
        cache[2][k] |= bit;
        return true;
    }
}
