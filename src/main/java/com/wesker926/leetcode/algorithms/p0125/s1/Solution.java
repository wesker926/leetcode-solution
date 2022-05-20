package com.wesker926.leetcode.algorithms.p0125.s1;

/**
 * @author wesker.gh
 * @date 2022/5/20
 * @description 双指针
 */
public class Solution {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            for (; i < j && !Character.isLetterOrDigit(s.charAt(i)); i++) {
            }
            for (; i < j && !Character.isLetterOrDigit(s.charAt(j)); j--) {
            }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
