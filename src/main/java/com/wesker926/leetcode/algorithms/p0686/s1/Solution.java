package com.wesker926.leetcode.algorithms.p0686.s1;

/**
 * @author wesker.gh
 * @date 2021/12/22
 * @description KMP + 循环索引
 */
public class Solution {
    public int repeatedStringMatch(String a, String b) {
        int l1 = a.length(), l2 = b.length(), idx = kmp(a.toCharArray(), b.toCharArray());
        return idx == -1 ? -1 : (idx + l2 - 1) / l1 + 1;
    }

    private int kmp(char[] a, char[] b) {
        int m = a.length, n = b.length;
        int[] pre = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && b[i] != b[j]) {
                j = pre[j - 1];
            }
            if (b[i] == b[j]) {
                j++;
            }
            pre[i] = j;
        }
        for (int i = 0, j = 0; i - j < m; i++) {
            while (j > 0 && a[i % m] != b[j]) {
                j = pre[j - 1];
            }
            if (a[i % m] == b[j]) {
                j++;
            }
            if (j == n) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
