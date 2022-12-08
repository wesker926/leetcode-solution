package com.wesker926.leetcode.algorithms.p1812.s1;

/**
 * @author wesker.gh
 * @date 2022/12/8
 * @description 数学
 * 判断奇偶
 */
public class Solution {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a') & 1) == ((coordinates.charAt(1) - '0') & 1);
    }
}
