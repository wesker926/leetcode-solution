package com.wesker926.leetcode.algorithms.p2042.s2;

/**
 * @author wesker.gh
 * @date 2023/1/3
 * @description 单指针遍历
 */
public class Solution {
    public boolean areNumbersAscending(String s) {
        for (int i = 0, pre = -1; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                continue;
            }
            int cur = 0;
            for (; i < s.length() && s.charAt(i) != ' '; i++) {
                cur = cur * 10 + s.charAt(i) - '0';
            }
            if (cur <= pre) {
                return false;
            }
            pre = cur;
        }
        return true;
    }
}
