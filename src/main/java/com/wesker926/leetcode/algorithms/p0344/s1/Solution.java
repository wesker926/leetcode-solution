package com.wesker926.leetcode.algorithms.p0344.s1;

/**
 * @author wesker.gh
 * @date 2023/8/7
 * @description 交换
 */
public class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) swap(s, i, s.length - 1 - i);
    }

    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
