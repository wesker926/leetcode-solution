package com.wesker926.leetcode.algorithms.p1374.s1;

/**
 * @author wesker.gh
 * @date 2022/8/1
 * @description 模拟
 */
public class Solution {
    public String generateTheString(int n) {
        return "a".repeat((n & 1) == 0 ? n - 1 : n) + ((n & 1) == 0 ? "b" : "");
    }
}
