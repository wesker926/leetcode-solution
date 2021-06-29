package com.wesker926.leetcode.algorithms.s0151to0200.s0168;

/**
 * @author wesker
 * @date 2021/6/29
 * @description 168. Excel表列名称
 */
public class Solution {
    /**
     * 迭代
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
