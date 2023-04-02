package com.wesker926.leetcode.algorithms.p0831.s1;

/**
 * @author wesker.gh
 * @date 2023/4/1
 * @description 模拟
 * 电话号码倒着录入更快
 */
public class Solution {

    public String maskPII(String s) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        if (Character.isLetter(s.charAt(0))) {
            for (s = s.toLowerCase(); idx < s.length() && s.charAt(idx) != '@'; idx++) ;
            return sb.append(s.charAt(0)).append("*****").append(s, idx - 1, s.length()).toString();
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(s.charAt(i))) {
                continue;
            }
            if ((++idx) == 5 || idx == 8 || idx == 11) {
                sb.append('-');
            }
            sb.append(idx < 5 ? s.charAt(i) : '*');
        }
        return sb.append(idx > 10 ? '+' : "").reverse().toString();
    }
}
