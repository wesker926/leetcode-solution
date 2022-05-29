package com.wesker926.leetcode.algorithms.p1021.s1;

/**
 * @author wesker.gh
 * @date 2022/5/28
 * @description 栈
 */
public class Solution {
    public String removeOuterParentheses(String s) {
        char[] stack = new char[s.length()];
        int idx = 0, count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            stack[idx++] = c;
            count += c == '(' ? 1 : -1;
            if (count == 0) {
                sb.append(stack, 1, idx - 2);
                idx = 0;
            }
        }
        return sb.toString();
    }
}
