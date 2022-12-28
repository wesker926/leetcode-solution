package com.wesker926.leetcode.algorithms.p1750.s1;

/**
 * @author wesker.gh
 * @date 2022/12/28
 * @description 双指针
 */
public class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char ch = s.charAt(i);
            for (; i <= j && ch == s.charAt(i); i++) ;
            for (; i <= j && ch == s.charAt(j); j--) ;
        }
        return j - i + 1;
    }
}
