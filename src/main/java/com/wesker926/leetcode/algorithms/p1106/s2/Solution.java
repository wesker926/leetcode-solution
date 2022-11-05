package com.wesker926.leetcode.algorithms.p1106.s2;

/**
 * @author wesker.gh
 * @date 2022/11/5
 * @description 栈
 */
public class Solution {
    public boolean parseBoolExpr(String expression) {
        char[] stack = new char[expression.length()];
        for (int idx = 0, i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ',') {
                continue;
            }
            if (c != ')') {
                stack[idx++] = c;
                continue;
            }

            int countT = 0, countF = 0;
            for (idx--; stack[idx] != '('; idx--) {
                countT += stack[idx] == 't' ? 1 : 0;
                countF += stack[idx] == 'f' ? 1 : 0;
            }
            stack[idx - 1] = (stack[idx - 1] == '!' && countF != 0) ||
                    (stack[idx - 1] == '&' && countF == 0) ||
                    (stack[idx - 1] == '|' && countT != 0) ? 't' : 'f';
        }
        return stack[0] == 't';
    }
}
