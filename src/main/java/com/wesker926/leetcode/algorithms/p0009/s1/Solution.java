package com.wesker926.leetcode.algorithms.p0009.s1;

/**
 * @author wesker.gh
 * @date 2022/4/21
 * @description 反转一半数字
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || ((x % 10) == 0 && x != 0)) {
            return false;
        }
        for (int y = 0; x >= y; y = y * 10 + (x % 10), x /= 10) {
            if (x == y || x / 10 == y) {
                return true;
            }
        }
        return false;
    }
}
