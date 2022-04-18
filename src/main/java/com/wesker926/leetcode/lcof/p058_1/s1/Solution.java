package com.wesker926.leetcode.lcof.p058_1.s1;

/**
 * @author wesker.gh
 * @date 2022/4/18
 * @description 双指针
 */
public class Solution {
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder(cs.length);
        for (int i = 0, j = 0; j <= cs.length; j++) {
            if (j == cs.length || cs[j] == ' ') {
                if (i != j) {
                    for (int k = j - 1; k >= i; k--) {
                        sb.append(cs[k]);
                    }
                    sb.append(' ');
                }
                i = j + 1;
            }
        }
        return sb.length() == 0 ? "" : sb.deleteCharAt(sb.length() - 1).reverse().toString();
    }
}
