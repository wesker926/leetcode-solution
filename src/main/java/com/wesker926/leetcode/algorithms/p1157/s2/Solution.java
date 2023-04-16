package com.wesker926.leetcode.algorithms.p1157.s2;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/4/16
 * @description 二进制分块前缀和
 * 空间优化，将每32个数分成一块儿，通过int记录这32个数在某一位是否为1，再对块儿做前缀和
 * 牺牲时间优化空间
 */
public class Solution {

    private final int[] idx;

    private final int[][] pre;

    private final int[][] chunk;

    public Solution(int[] arr) {
        int n = arr.length;
        idx = new int[n];
        pre = new int[(n >> 5) + 1][16];
        chunk = new int[(n >> 5) + 1][16];
        for (int i = 0; i < n; i++) {
            idx[i] = (arr[i] << 16) | i;
            int ci = i >> 5, si = i & 31;
            for (int j = 0; j < 16; j++) {
                chunk[ci][j] |= ((arr[i] >> j) & 1) << si;
                if (si == 31 || i == n - 1) {
                    pre[ci][j] = (ci != 0 ? pre[ci - 1][j] : 0) + Integer.bitCount(chunk[ci][j]);
                }
            }
        }
        if ((n & 31) == 0) {
            pre[pre.length - 1] = pre[pre.length - 2];
        }
        Arrays.sort(idx);
    }

    public int query(int left, int right, int threshold) {
        right++;
        int candidate = 0, lci = left >> 5, lsi = left & 31, rci = right >> 5, rsi = right & 31;
        for (int i = 0; i < 16; i++) {
            int one = pre[rci][i] - Integer.bitCount(chunk[rci][i] >>> rsi) -
                    (pre[lci][i] - Integer.bitCount(chunk[lci][i] >>> lsi));
            int zero = right - left + 1 - one;
            if (one < threshold && zero < threshold) {
                return -1;
            } else if (one >= threshold) {
                candidate |= 1 << i;
            }
        }
        int r = Arrays.binarySearch(idx, (candidate << 16) | right);
        int l = (r >= 0 ? r : -r - 1) - threshold;
        if (l < 0 || idx[l] < ((candidate << 16) | left)) {
            return -1;
        }
        return candidate;
    }
}
