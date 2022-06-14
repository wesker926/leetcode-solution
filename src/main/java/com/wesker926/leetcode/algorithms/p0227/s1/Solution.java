package com.wesker926.leetcode.algorithms.p0227.s1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author wesker.gh
 * @date 2022/6/14
 * @description 双栈
 * 中缀表达式计算
 */
public class Solution {

    private static final Map<Character, BiFunction<Integer, Integer, Integer>> OPERATION;

    static {
        OPERATION = new HashMap<>();
        OPERATION.put('+', (a, b) -> a + b);
        OPERATION.put('-', (a, b) -> a - b);
        OPERATION.put('*', (a, b) -> a * b);
        OPERATION.put('/', (a, b) -> a / b);
    }

    public int calculate(String s) {
        int n = s.length(), idx1 = 0, idx2 = 0;
        int[] numStack = new int[n];
        char[] opStack = new char[n];
        char[] origin = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (origin[i] == ' ') {
                continue;
            }
            if (Character.isDigit(origin[i])) {
                int digit = 0, j = i;
                for (; j < n && Character.isDigit(origin[j]); j++) {
                    digit = digit * 10 + origin[j] - '0';
                }
                numStack[idx1++] = digit;
                i = j - 1;
                continue;
            }
            while (idx2 != 0 && priority(opStack[idx2 - 1], origin[i])) {
                idx1 = calculate(numStack, idx1, opStack[--idx2]);
            }
            opStack[idx2++] = origin[i];
        }
        while (idx2 != 0) {
            idx1 = calculate(numStack, idx1, opStack[--idx2]);
        }
        return idx1 == 0 ? 0 : numStack[idx1 - 1];
    }

    private boolean priority(char op1, char op2) {
        return op1 == '*' || op1 == '/' || op2 == '+' || op2 == '-';
    }

    private int calculate(int[] stack, int idx, char op) {
        if (idx < 2) {
            return idx;
        }
        stack[idx - 2] = OPERATION.get(op).apply(stack[idx - 2], stack[idx - 1]);
        return idx - 1;
    }
}
