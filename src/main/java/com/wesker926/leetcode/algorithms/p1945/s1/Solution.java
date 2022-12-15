package com.wesker926.leetcode.algorithms.p1945.s1;

/**
 * @author wesker.gh
 * @date 2022/12/15
 * @description 模拟
 * 注：直接用数字效率更高
 */
public class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a' + 1;
            sum += (ch / 10) + (ch % 10);
        }
        for (k--; k > 0 && sum > 9; k--) {
            int t = 0;
            for (; sum > 0; sum /= 10) {
                t += sum % 10;
            }
            sum = t;
        }
        return sum;
    }
}
