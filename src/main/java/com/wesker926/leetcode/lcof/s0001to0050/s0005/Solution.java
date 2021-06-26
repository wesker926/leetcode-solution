package com.wesker926.leetcode.lcof.s0001to0050.s0005;

/**
 * @author wesker.gh
 * @date 2021/6/22
 * @description 剑指 Offer 05. 替换空格
 */
public class Solution {

    public static final String REPLACE = "%20";

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s.length() * 3);
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(REPLACE);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
