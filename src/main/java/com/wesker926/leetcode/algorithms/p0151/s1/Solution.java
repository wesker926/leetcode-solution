package com.wesker926.leetcode.algorithms.p0151.s1;

/**
 * @author wesker.gh
 * @date 2022/6/1
 * @description 双指针
 */
public class Solution {
    public String reverseWords(String s) {
        char[] cs = s.trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = cs.length - 1, j = i; j >= -1; j--) {
            if (j < 0 || cs[j] == ' ') {
                if (i != j) {
                    for (int k = j + 1; k <= i; k++) {
                        sb.append(cs[k]);
                    }
                    sb.append(' ');
                }
                i = j - 1;
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
