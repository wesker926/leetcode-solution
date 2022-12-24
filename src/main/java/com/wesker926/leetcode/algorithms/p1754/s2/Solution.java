package com.wesker926.leetcode.algorithms.p1754.s2;

/**
 * @author wesker.gh
 * @date 2022/12/24
 * @description 后缀数组
 */
public class Solution {
    public String largestMerge(String word1, String word2) {
        int[] rank = buildSuffixArray(word1 + '*' + word2 + '@');
        StringBuilder sb = new StringBuilder();
        int m = word1.length(), n = word2.length();
        for (int i = 0, j = 0; i < m || j < n; ) {
            if (i < m && rank[i] > rank[m + 1 + j]) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }

    private int[] buildSuffixArray(String s) {
        int[] sa = initSA(s);
        int[] rk = initRK(s, sa);
        for (int i = 1; i < s.length(); i <<= 1) {
            sa = updateSA(s, i, sa, rk);
            rk = updateRK(i, sa, rk);
        }
        return rk;
    }

    private int[] initSA(String s) {
        int n = s.length();
        int[] sa = new int[n];
        int[] bucket = new int[128];
        for (int i = 0; i < n; i++) {
            bucket[s.charAt(i)]++;
        }
        for (int i = 1; i < 128; i++) {
            bucket[i] += bucket[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            bucket[s.charAt(i)]--;
            sa[bucket[s.charAt(i)]] = i;
        }
        return sa;
    }

    private int[] initRK(String s, int[] sa) {
        int n = s.length();
        int[] rk = new int[n];
        rk[sa[0]] = 0;
        for (int i = 1; i < n; i++) {
            rk[sa[i]] = rk[sa[i - 1]] + (s.charAt(sa[i - 1]) != s.charAt(sa[i]) ? 1 : 0);
        }
        return rk;
    }

    private int[] updateSA(String s, int len, int[] sa, int[] rk) {
        int n = s.length();
        int[] newSA = new int[n];
        int[] bucket = new int[n];
        for (int r : rk) {
            bucket[r]++;
        }
        for (int i = 1; i < n; i++) {
            bucket[i] += bucket[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int start = (sa[i] - len + n) % n;
            int r = rk[start];
            bucket[r]--;
            newSA[bucket[r]] = start;
        }
        return newSA;
    }

    private int[] updateRK(int len, int[] sa, int[] rk) {
        int n = sa.length;
        int[] newRK = new int[n];
        newRK[sa[0]] = 0;
        for (int i = 1; i < n; i++) {
            int curSt = sa[i], preSt = sa[i - 1];
            int curMid = curSt + len, preMid = (preSt + len) % n;
            newRK[curSt] = newRK[preSt] + (rk[curSt] != rk[preSt] || rk[curMid] != rk[preMid] ? 1 : 0);
        }
        return newRK;
    }
}
