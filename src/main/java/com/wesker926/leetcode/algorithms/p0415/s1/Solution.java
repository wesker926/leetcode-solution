package com.wesker926.leetcode.algorithms.p0415.s1;

/**
 * @author wesker.gh
 * @date 2023/7/17
 * @description 模拟
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1, c = 0; i >= 0 || j >= 0 || c > 0; c /= 10) {
            if (i >= 0) c += num1.charAt(i--) - '0';
            if (j >= 0) c += num2.charAt(j--) - '0';
            sb.append((char) (c % 10 + '0'));
        }
        return sb.reverse().toString();
    }
}
