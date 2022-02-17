package com.wesker926.leetcode.expand.notation;

import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/2/17
 * @description 中缀表达式 -> 逆波兰表达式（后缀表达式）
 * 假设输入的中缀表达式合法，运算符仅包含+ - * / ( )
 * 输出的表达式以" "分割
 */
public class ToReversePolishNotation {
    public String convert(String s) {
        char[] cs = s.toCharArray();
        LinkedList<String> stack = new LinkedList<>();
        LinkedList<Character> opStack = new LinkedList<>();
        for (int i = 0; i < cs.length; i++) {
            if (Character.isDigit(cs[i])) {
                StringBuilder sb = new StringBuilder();
                for (; i < cs.length && Character.isDigit(cs[i]); i++) {
                    sb.append(cs[i]);
                }
                i--;
                stack.push(sb.toString());
            } else {
                if (cs[i] == '(') {
                    opStack.push(cs[i]);
                } else if (cs[i] == ')') {
                    while (!opStack.isEmpty() && opStack.peek() != '(') {
                        stack.push(String.valueOf(opStack.pop()));
                    }
                    if (!opStack.isEmpty()) {
                        opStack.pop();
                    }
                } else {
                    while (!opStack.isEmpty() && !priority(opStack.peek(), cs[i])) {
                        stack.push(String.valueOf(opStack.pop()));
                    }
                    opStack.push(cs[i]);
                }
            }
        }
        while (!opStack.isEmpty()) {
            stack.push(String.valueOf(opStack.pop()));
        }
        return new StringBuilder(String.join(" ", stack.toArray(new String[0]))).reverse().toString();
    }

    /**
     * 当op2优先级高返回true
     */
    private boolean priority(char op1, char op2) {
        return (op1 == '(') || ((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/'));
    }

    public static void main(String[] args) {
        System.out.println(new ToReversePolishNotation().convert("1+2*3/((21-545/3)+23*564/(14-5)-536)"));
    }
}
