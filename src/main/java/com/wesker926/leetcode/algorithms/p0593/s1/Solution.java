package com.wesker926.leetcode.algorithms.p0593.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/7/29
 * @description 正方形判断
 * 四条边相同，两条对角线相同，且都不为0。
 */
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] ls = new int[]{length(p1, p2), length(p1, p3), length(p1, p4), length(p2, p3), length(p2, p4), length(p3, p4)};
        Arrays.sort(ls);
        return ls[0] != 0 && ls[0] == ls[1] && ls[1] == ls[2] && ls[2] == ls[3] && ls[4] == ls[5];
    }

    private int length(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
