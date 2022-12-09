package com.wesker926.leetcode.algorithms.p1780.s1;

/**
 * @author wesker.gh
 * @date 2022/12/9
 * @description 数学
 * 转换为3进制，若该数字只出现01则符合
 */
public class Solution {
    public boolean checkPowersOfThree(int n) {
        for (; n != 0; n /= 3) {
            if (n % 3 > 1) {
                return false;
            }
        }
        return true;
    }
}
