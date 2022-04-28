package com.wesker926.leetcode.algorithms.p0036.s1;

/**
 * @author wesker.gh
 * @date 2022/4/28
 * @description 遍历检查
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int[] row = new int[9], col = new int[9], block = new int[9];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int t = board[i][j] - '0';
                if (!checkAndMark(row, i, t) ||
                        !checkAndMark(col, j, t) ||
                        !checkAndMark(block, (i / 3) * 3 + j / 3, t)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkAndMark(int[] arr, int idx, int bit) {
        if ((arr[idx] & (1 << bit)) != 0) {
            return false;
        }
        arr[idx] |= 1 << bit;
        return true;
    }
}
