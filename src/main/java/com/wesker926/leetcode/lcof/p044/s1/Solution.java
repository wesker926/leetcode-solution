package com.wesker926.leetcode.lcof.p044.s1;

/**
 * @author wesker.gh
 * @date 2022/4/15
 * @description 计算
 */
public class Solution {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }

        long numSize = 2, numCount = 90;
        for (n -= 10; n >= numSize * numCount; numSize++, numCount *= 10) {
            n -= numSize * numCount;
        }

        int num = (int) (n / numSize + numCount / 9);
        for (int bit = (int) (numSize - (n % numSize) - 1); bit > 0; bit--) {
            num /= 10;
        }
        return num % 10;
    }
}
