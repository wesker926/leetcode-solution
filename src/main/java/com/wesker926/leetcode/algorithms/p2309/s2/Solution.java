package com.wesker926.leetcode.algorithms.p2309.s2;

/**
 * @author wesker.gh
 * @date 2023/1/27
 * @description 位运算
 * 没有哈希表快，因为运算更多
 * 优点是空间复杂度低
 */
public class Solution {
    public String greatestLetter(String s) {
        int lower = 0, upper = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                lower |= 1 << (ch - 'a');
            } else {
                upper |= 1 << (ch - 'A');
            }
        }
        for (int i = 25, bit = lower & upper; i >= 0; i--) {
            if ((bit & (1 << i)) != 0) {
                return String.valueOf((char) (i + 'A'));
            }
        }
        return "";
    }
}
