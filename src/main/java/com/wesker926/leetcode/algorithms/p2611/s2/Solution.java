package com.wesker926.leetcode.algorithms.p2611.s2;

/**
 * @author wesker.gh
 * @date 2023/6/7
 * @description 计数排序
 */
public class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0, n = reward1.length;
        int[] table = new int[2000];
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            table[reward1[i] - reward2[i] + 1000]++;
        }
        for (int i = 1999, j = 0, c; i > 0 && j < k; i--, j += c) {
            c = Math.min(table[i], k - j);
            ans += (i - 1000) * c;
        }
        return ans;
    }
}
