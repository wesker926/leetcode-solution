package com.wesker926.leetcode.algorithms.p0647.s2;

/**
 * @author wesker.gh
 * @date 2021/12/24
 * @description 中心拓展
 */
public class Solution {
    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        int n = s.length(), ans = 0, l, r;
        for (int i = 0; i < n * 2 - 1; i++) {
            l = i / 2;
            r = i / 2 + (i & 1);
            while (l >= 0 && r < n && cs[l] == cs[r]) {
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }
}
