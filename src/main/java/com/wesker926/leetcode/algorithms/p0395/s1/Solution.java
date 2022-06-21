package com.wesker926.leetcode.algorithms.p0395.s1;

/**
 * @author wesker.gh
 * @date 2022/6/21
 * @description 分治 + 前缀和
 * 前缀和意义不大
 */
public class Solution {

    private int[][] pre;

    public int longestSubstring(String s, int k) {
        pre = new int[s.length() + 1][26];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            System.arraycopy(pre[i], 0, pre[i + 1], 0, 26);
            pre[i + 1][cs[i] - 'a']++;
        }
        return dfs(cs, 0, cs.length - 1, k);
    }

    private int dfs(char[] cs, int st, int ed, int k) {
        if (ed - st + 1 < k) {
            return 0;
        }
        int ans = -1, i = st, j = st;
        for (; j <= ed; j++) {
            int ch = cs[j] - 'a', cnt = pre[ed + 1][ch] - pre[st][ch];
            if (cnt < k) {
                ans = Math.max(ans, dfs(cs, i, j - 1, k));
                i = j + 1;
            }
        }
        return ans < 0 ? ed - st + 1 : Math.max(ans, dfs(cs, i, j - 1, k));
    }
}
