package com.wesker926.leetcode.algorithms.p0821.s1;

/**
 * @author wesker.gh
 * @date 2022/4/19
 * @description 双指针
 */
public class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        char[] cs = s.toCharArray();
        for (int i = 0, j = 0, k = -n; j <= n; j++) {
            if (j == n || cs[j] == c) {
                for (; i < n && i <= j; i++) {
                    ans[i] = Math.min(i - k, j == n ? n : j - i);
                }
                k = j;
                i = j + 1;
            }
        }
        return ans;
    }
}
