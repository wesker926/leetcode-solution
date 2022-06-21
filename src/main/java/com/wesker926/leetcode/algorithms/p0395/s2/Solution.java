package com.wesker926.leetcode.algorithms.p0395.s2;

/**
 * @author wesker.gh
 * @date 2022/6/21
 * @description 分治
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        return dfs(s.toCharArray(), 0, s.length() - 1, k);
    }

    private int dfs(char[] cs, int st, int ed, int k) {
        if (ed - st + 1 < k) {
            return 0;
        }
        int[] cnt = new int[26];
        for (int i = st; i <= ed; i++) {
            cnt[cs[i] - 'a']++;
        }
        int ans = -1, i = st, j = st;
        for (; j <= ed; j++) {
            if (cnt[cs[j] - 'a'] < k) {
                ans = Math.max(ans, dfs(cs, i, j - 1, k));
                i = j + 1;
            }
        }
        return ans < 0 ? ed - st + 1 : Math.max(ans, dfs(cs, i, j - 1, k));
    }
}
