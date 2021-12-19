package com.wesker926.leetcode.algorithms.p0997.s1;

/**
 * @author wesker.gh
 * @date 2021/12/19
 * @description 遍历（图入度出度）
 */
public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] bucket = new int[n + 1];
        for (int[] t : trust) {
            bucket[t[1]]++;
            bucket[t[0]]--;
        }

        for (int i = 1; i <= n; i++) {
            if (bucket[i] == n - 1) {
                return i;
            }
        }
        return n == 1 ? 1 : -1;
    }
}
