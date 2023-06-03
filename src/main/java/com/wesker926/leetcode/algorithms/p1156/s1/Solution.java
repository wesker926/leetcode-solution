package com.wesker926.leetcode.algorithms.p1156.s1;

/**
 * @author wesker.gh
 * @date 2023/6/3
 * @description 滑动窗口
 */
public class Solution {
    public int maxRepOpt1(String text) {
        int n = text.length(), ans = 0;
        char[] cs = text.toCharArray();
        int[] count = new int[26];
        for (char c : cs) count[c - 'a']++;
        for (int i = 0, j = i, k, l, c; i < n; l = k - j <= 2 ? 0 : 1, i = j + l, j = l == 0 ? j + 1 : k) {
            for (c = count[cs[i] - 'a']; j < n && cs[j] == cs[i]; j++) ;
            if (j == n && i != 0) ans = Math.max(ans, Math.min(j - i + 1, c));
            for (k = (j == n) ? j : j + 1; k < n && cs[k] == cs[i]; k++) ;
            ans = Math.max(ans, Math.min(k - i, c));
        }
        return ans;
    }
}
