package com.wesker926.leetcode.algorithms.p1921.s2;

/**
 * @author wesker.gh
 * @date 2023/9/3
 * @description 计数排序 + 贪心
 */
public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] time = new int[n + 1];
        for (int i = 0; i < n; i++) time[Math.min((dist[i] - 1) / speed[i] + 1, n)]++;
        for (int i = 0, add = 0; i < n; i++) if (i < (add += time[i])) return i;
        return n;
    }
}
