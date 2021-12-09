package com.wesker926.leetcode.algorithms.p0794.s1;

/**
 * @author wesker.gh
 * @date 2021/12/9
 * @description 检查
 */
public class Solution {

    private static final int[][] CHECK = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public boolean validTicTacToe(String[] board) {
        int count1 = 0, count2 = 0, k = 0;
        int[] b = new int[9];
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X') {
                    count1++;
                    b[k] = 1;
                } else if (c == 'O') {
                    count2++;
                    b[k] = 2;
                }
                k++;
            }
        }

        if (count2 > count1 || count1 - count2 > 1) {
            return false;
        }

        k = 0;
        int[] finish = new int[2];
        for (int[] ints : CHECK) {
            if (b[ints[0]] != 0 && b[ints[0]] == b[ints[1]] && b[ints[0]] == b[ints[2]]) {
                finish[k++] = b[ints[0]];
            }
        }

        if (k == 0) {
            return true;
        }

        if (count1 == count2) {
            return k == 1 && finish[0] == 2;
        }

        return (k == 2 && finish[0] == finish[1]) || (k == 1 && finish[0] == 1);
    }
}
