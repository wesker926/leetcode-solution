package com.wesker926.leetcode.algorithms.p0640.s1;

/**
 * @author wesker.gh
 * @date 2022/8/10
 * @description 解析
 */
public class Solution {
    public String solveEquation(String equation) {
        String[] sp = equation.split("=");
        int[] left = parse(sp[0].toCharArray(), 1), right = parse(sp[1].toCharArray(), -1);
        int constant = left[0] + right[0], variable = left[1] + right[1];
        return variable == 0 ? (constant == 0 ? "Infinite solutions" : "No solution") : "x=" + (-constant / variable);
    }

    private int[] parse(char[] expr, int isLeft) {
        int constant = 0, variable = 0;
        for (int i = 0, j = 0, sign = 1; j <= expr.length; j++) {
            if (j == expr.length || expr[j] == '+' || expr[j] == '-') {
                if (i != j) {
                    int digit = 0;
                    for (int k = i; k < j && Character.isDigit(expr[k]); k++) {
                        digit = digit * 10 + (expr[k] - '0');
                    }
                    if (expr[j - 1] != 'x') {
                        constant += sign * isLeft * digit;
                    } else {
                        if (i + 1 == j) {
                            digit = 1;
                        }
                        variable += sign * isLeft * digit;
                    }
                }
                sign = j == expr.length || expr[j] == '+' ? 1 : -1;
                i = j + 1;
            }
        }
        return new int[]{constant, variable};
    }
}
