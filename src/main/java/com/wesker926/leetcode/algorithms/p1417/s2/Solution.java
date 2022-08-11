package com.wesker926.leetcode.algorithms.p1417.s2;

/**
 * @author wesker.gh
 * @date 2022/8/11
 * @description 遍历 + 交替拼接
 * 无需队列
 */
public class Solution {
    public String reformat(String s) {
        int digit = 0, letter = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (Character.isDigit(c)) {
                digit++;
            } else {
                letter++;
            }
        }
        if (Math.abs(digit - letter) > 1) {
            return "";
        }
        if (digit >= letter) {
            digit = 0;
            letter = 1;
        } else {
            digit = 1;
            letter = 0;
        }
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                cs[digit] = c;
                digit += 2;
            } else {
                cs[letter] = c;
                letter += 2;
            }
        }
        return new String(cs);
    }
}
