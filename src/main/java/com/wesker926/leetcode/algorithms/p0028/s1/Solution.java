package com.wesker926.leetcode.algorithms.p0028.s1;

/**
 * @author wesker.gh
 * @date 2022/4/27
 * @description KMP
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] pcs = haystack.toCharArray();
        char[] ccs = needle.toCharArray();
        int[] pi = new int[ccs.length];
        for (int i = 1, j = 0; i < ccs.length; i++) {
            while (j > 0 && ccs[j] != ccs[i]) {
                j = pi[j - 1];
            }
            if (ccs[i] == ccs[j]) {
                j++;
            }
            pi[i] = j;
        }

        for (int i = 0, j = 0; i < pcs.length; i++) {
            while (j > 0 && pcs[i] != ccs[j]) {
                j = pi[j - 1];
            }
            if (pcs[i] == ccs[j]) {
                j++;
            }
            if (j == ccs.length) {
                return i - ccs.length + 1;
            }
        }
        return -1;
    }
}
