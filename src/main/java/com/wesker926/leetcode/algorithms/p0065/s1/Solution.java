package com.wesker926.leetcode.algorithms.p0065.s1;

/**
 * @author wesker.gh
 * @date 2022/5/3
 * @description 遍历（同lcof-p020）
 */
public class Solution {
    public boolean isNumber(String s) {
        char[] cs = s.toCharArray();
        boolean point = false;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '+' || c == '-') {
                if (i != 0 || i == cs.length - 1 || (!Character.isDigit(cs[i + 1]) && cs[i + 1] != '.')) {
                    return false;
                }
            } else if (c == '.') {
                if (point || ((i == 0 || !Character.isDigit(cs[i - 1])) && (i == cs.length - 1 || !Character.isDigit(cs[i + 1])))) {
                    return false;
                }
                point = true;
            } else if (Character.toLowerCase(c) == 'e') {
                return i != 0 && i != cs.length - 1 && isInt(cs, i + 1, cs.length - 1);
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInt(char[] cs, int s, int e) {
        int idx = cs[s] == '+' || cs[s] == '-' ? s + 1 : s;
        for (int i = idx; i <= e; i++) {
            if (!Character.isDigit(cs[i])) {
                return false;
            }
        }
        return idx <= e;
    }
}
