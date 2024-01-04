package com.wesker926.leetcode.algorithms.p2397.s1;

/**
 * @author wesker.gh
 * @date 2024/1/4
 * @description 二进制枚举的 Gosper's Hack 优化
 * Gosper's Hack 即找到二进制串中从低到高第一个遇到的01，将它变为10，就是下一个组合
 * 如101 -> 110
 */
public class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[] rows = new int[m];
        for (int i = 0; i < m; i++) {
            for (int col : matrix[i]) rows[i] = (rows[i] << 1) | col;
        }
        for (int bit = (1 << numSelect) - 1, nxt; ; bit = nxt) {
            int cnt = 0;
            for (int row : rows) if ((bit | row) == bit) cnt++;
            res = Math.max(res, cnt);

            nxt = bit;
            for (int i = 0, c = 0; i < n; i++) {
                if (((nxt >> i) & 1) == 1) {
                    c++;
                    continue;
                }
                if (c == 0) continue;
                nxt = (((nxt >> i) | 1) << i) | ((1 << (c - 1)) - 1);
                break;
            }
            if (nxt == bit) break;
        }
        return res;
    }
}
