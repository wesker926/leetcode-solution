package com.wesker926.leetcode.algorithms.p1796.s1;

/**
 * @author wesker.gh
 * @date 2022/12/3
 * @description 遍历
 */
public class Solution {
    public int secondHighest(String s) {
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                continue;
            }
            if ((ch -= '0') > first) {
                second = first;
                first = ch;
            } else if (ch < first && ch > second) {
                second = ch;
            }
        }
        return second;
    }
}
