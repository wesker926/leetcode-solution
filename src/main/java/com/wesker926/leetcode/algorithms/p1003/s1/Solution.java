package com.wesker926.leetcode.algorithms.p1003.s1;

/**
 * @author wesker.gh
 * @date 2023/5/3
 * @description 栈
 * 1.因为需要按顺序存，因为像ab只需要存b
 * 2.可以利用toCharArray作为栈
 */
public class Solution {
    public boolean isValid1(String s) {
        int i = 0;
        char[] stack = new char[s.length()];
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (ch > 'a' && (i == 0 || ch - stack[i - 1] != 1)) return false;
            if (ch < 'c') stack[i++] = ch;
            else i -= 2;
        }
        return i == 0;
    }

    public boolean isValid(String s) {
        int i = 0;
        char[] cs = s.toCharArray();
        for (char ch : cs) {
            if (ch > 'a' && (i == 0 || ch - cs[--i] != 1)) return false;
            if (ch < 'c') cs[i++] = ch;
        }
        return i == 0;
    }
}
