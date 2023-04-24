package com.wesker926.leetcode.algorithms.p1163.s1;

/**
 * @author wesker.gh
 * @date 2023/4/24
 * @description 双指针
 */
public class Solution {
    public String lastSubstring(String s) {
        int i = 0, n = s.length();
        char[] cs = s.toCharArray();
        for (int j = 1, k; j < n; ) {
            for (k = 0; j + k < n && cs[i + k] == cs[j + k]; k++) ;
            if (j + k < n && cs[i + k] < cs[j + k]) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return new String(cs, i, n - i);
    }
}
