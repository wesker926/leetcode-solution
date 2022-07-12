package com.wesker926.leetcode.algorithms.p1252.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/7/12
 * @description 统计奇偶行列数
 */
public class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m], col = new int[n];
        for (int[] idx : indices) {
            row[idx[0]] ^= 1;
            col[idx[1]] ^= 1;
        }
        int oddRow = Arrays.stream(row).sum(), oddCol = Arrays.stream(col).sum();
        return oddRow * (n - oddCol) + (m - oddRow) * oddCol;
    }
}
