package com.wesker926.leetcode.algorithms.p0258.s1;

/**
 * @author wesker.gh
 * @date 2022/3/3
 * @description 周期性出现
 */
public class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
