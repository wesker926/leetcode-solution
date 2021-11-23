package com.wesker926.leetcode.algorithms.p0859.s1;

/**
 * @author wesker.gh
 * @date 2021/11/23
 * @description 遍历
 */
public class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (n != goal.length()) {
            return false;
        }

        int idx = 0;
        boolean same = false;
        int[] diff = new int[n];
        boolean[] set = new boolean[26];
        char[] cs1 = s.toCharArray(), cs2 = goal.toCharArray();
        for (int i = 0; i < n; i++) {
            if (cs1[i] != cs2[i]) {
                diff[idx++] = i;
            }

            if (set[cs1[i] - 'a']) {
                same = true;
            }
            set[cs1[i] - 'a'] = true;
        }

        return (idx == 0 && same) || (idx == 2 && cs1[diff[0]] == cs2[diff[1]] && cs1[diff[1]] == cs2[diff[0]]);
    }
}
