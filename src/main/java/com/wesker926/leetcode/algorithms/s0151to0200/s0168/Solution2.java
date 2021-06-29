package com.wesker926.leetcode.algorithms.s0151to0200.s0168;

/**
 * @author wesker
 * @date 2021/6/29
 * @description 168. Excel表列名称
 */
public class Solution2 {
    /**
     * 递归
     */
    public String convertToTitle(int columnNumber) {
        return recursion(columnNumber, new StringBuilder()).reverse().toString();
    }

    private StringBuilder recursion(int num, StringBuilder sb) {
        if (num == 0) {
            return sb;
        }
        num--;
        sb.append((char) (num % 26 + 'A'));
        return recursion(num / 26, sb);
    }
}
