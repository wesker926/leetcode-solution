package com.wesker926.leetcode.algorithms.p2042.s1;

/**
 * @author wesker.gh
 * @date 2023/1/3
 * @description 双指针遍历
 */
public class Solution {
    public boolean areNumbersAscending(String s) {
        for (int i = 0, j = 0, pre = -1; j <= s.length(); j++) {
            if (j < s.length() && s.charAt(j) != ' ') {
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                int cur = 0;
                for (; i < j; i++) {
                    cur = cur * 10 + s.charAt(i) - '0';
                }
                if (cur <= pre) {
                    return false;
                }
                pre = cur;
            }
            i = j + 1;
        }
        return true;
    }
}
