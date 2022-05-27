package com.wesker926.leetcode.algorithms.p0150.s1;

/**
 * @author wesker.gh
 * @date 2022/5/27
 * @description 栈模拟（switch）
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int idx = 0;
        for (String token : tokens) {
            if (token.length() != 1 || Character.isDigit(token.charAt(0))) {
                stack[idx++] = Integer.parseInt(token);
                continue;
            }

            if (idx < 2) {
                return 0;
            }
            stack[idx - 2] = compute(token.charAt(0), stack[idx - 2], stack[idx - 1]);
            idx--;
        }
        return idx == 0 ? 0 : stack[idx - 1];
    }

    private int compute(char op, int a, int b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }
}
