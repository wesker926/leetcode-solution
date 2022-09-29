package com.wesker926.leetcode.igc.p01_09.s1;

/**
 * @author wesker.gh
 * @date 2022/9/29
 * @description 拼接搜索
 * 一个串重复两次即可规避循环的问题
 */
public class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
