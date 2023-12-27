package com.wesker926.leetcode.algorithms.p2660.s1;

/**
 * @author wesker.gh
 * @date 2023/12/27
 * @description 枚举
 */
public class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int s1 = 0, s2 = 0;
        for (int i = 0; i < player1.length; i++) {
            s1 += player1[i] << ((i >= 1 && player1[i - 1] == 10) || (i >= 2 && player1[i - 2] == 10) ? 1 : 0);
            s2 += player2[i] << ((i >= 1 && player2[i - 1] == 10) || (i >= 2 && player2[i - 2] == 10) ? 1 : 0);
        }
        return s1 == s2 ? 0 : (s1 > s2 ? 1 : 2);
    }
}