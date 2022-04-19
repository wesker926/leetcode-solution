package com.wesker926.leetcode.lcof.p067.s1;

/**
 * @author wesker.gh
 * @date 2022/4/19
 * @description 遍历解析
 */
public class Solution {
    public int strToInt(String str) {
        char[] cs = str.toCharArray();
        int ans = 0, sign = 1, idx = 0, max = Integer.MAX_VALUE / 10;

        for (; idx < cs.length && cs[idx] == ' '; idx++) {
        }
        if (idx == cs.length) {
            return 0;
        }

        if (cs[idx] == '+' || cs[idx] == '-') {
            if (cs[idx] == '-') {
                sign = -1;
            }
            idx++;
        }

        for (int c; idx < cs.length && Character.isDigit(cs[idx]); idx++) {
            c = cs[idx] - '0';
            if (ans > max || (ans == max && c > 7)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + c;
        }
        return ans * sign;
    }
}
