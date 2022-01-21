package com.wesker926.leetcode.algorithms.p1332.s1;

/**
 * @author wesker.gh
 * @date 2022/1/22
 * @description 判断回文串
 */
public class Solution {
    public int removePalindromeSub(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length - 1; i <= j; i++, j--) {
            if (cs[i] != cs[j]) {
                return 2;
            }
        }
        return 1;
    }
}
