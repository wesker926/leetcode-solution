package com.wesker926.leetcode.algorithms.p1021.s2;

/**
 * @author wesker.gh
 * @date 2022/5/28
 * @description 双指针
 */
public class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        for (int i = 0, j = 0, count = 0; j < cs.length; j++) {
            count += cs[j] == '(' ? 1 : -1;
            if (count == 0) {
                sb.append(cs, i + 1, j - i - 1);
                i = j + 1;
            }
        }
        return sb.toString();
    }
}
