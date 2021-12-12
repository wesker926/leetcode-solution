package com.wesker926.leetcode.algorithms.p0709.s1;

/**
 * @author wesker.gh
 * @date 2021/12/12
 * @description ...
 */
public class Solution {

    private static final int DIFF = 'A' - 'a';

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c >= 'A' && c <= 'Z' ? (char) (c - DIFF) : c);
        }
        return sb.toString();
    }
}
