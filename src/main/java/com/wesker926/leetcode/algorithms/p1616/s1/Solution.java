package com.wesker926.leetcode.algorithms.p1616.s1;

/**
 * @author wesker.gh
 * @date 2023/3/18
 * @description 双指针
 * 本质上是双指针
 */
public class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        int n = a.length(), center = Math.max(maxCenterPalindromeLen(a), maxCenterPalindromeLen(b)),
                fix = Math.max(maxFixPalindromeLen(a, b), maxFixPalindromeLen(b, a));
        return center + fix * 2 >= n;
    }

    private int maxCenterPalindromeLen(String s) {
        int i = s.length() / 2 - 1, j = (s.length() + 1) / 2;
        for (; i >= 0 && s.charAt(i) == s.charAt(j); i--, j++) ;
        return j - i - 1;
    }

    private int maxFixPalindromeLen(String a, String b) {
        int n = a.length(), i = 0;
        for (; i < n && a.charAt(i) == b.charAt(n - 1 - i); i++) ;
        return i;
    }
}
