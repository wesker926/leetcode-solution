package com.wesker926.leetcode.algorithms.p0020.s1;

/**
 * @author wesker.gh
 * @date 2022/4/25
 * @description 栈
 */
public class Solution {
    public boolean isValid(String s) {
        char[] cs = s.toCharArray(), stack = new char[cs.length];
        int idx = 0;
        for (char c : cs) {
            if (c == '(' || c == '[' || c == '{') {
                stack[idx++] = c;
            } else if (idx == 0 ||
                    (c == ')' && stack[idx - 1] != '(') ||
                    (c == ']' && stack[idx - 1] != '[') ||
                    (c == '}' && stack[idx - 1] != '{')) {
                return false;
            } else {
                idx--;
            }
        }
        return idx == 0;
    }
}
