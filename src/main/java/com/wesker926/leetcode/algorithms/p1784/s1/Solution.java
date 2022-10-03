package com.wesker926.leetcode.algorithms.p1784.s1;

/**
 * @author wesker.gh
 * @date 2022/10/3
 * @description 遍历
 * 出现0后不能出现1，所以不包含01即可
 */
public class Solution {
    public boolean checkOnesSegment(String s) {
//        return !s.contains("01");
        boolean meetZero = false;
        for (char c : s.toCharArray()) {
            if (!meetZero && c == '0') {
                meetZero = true;
            }
            if (meetZero && c == '1') {
                return false;
            }
        }
        return true;
    }
}
