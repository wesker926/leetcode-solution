package com.wesker926.leetcode.algorithms.p1816.s1;

/**
 * @author wesker.gh
 * @date 2021/12/6
 * @description 遍历
 */
public class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                k--;
                if (k == 0) {
                    break;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
