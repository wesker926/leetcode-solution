package com.wesker926.leetcode.algorithms.p0605.s1;

/**
 * @author wesker.gh
 * @date 2023/9/29
 * @description 贪心
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeroCount = 1, res = 0;
        for (int x : flowerbed) {
            if (x == 0) zeroCount++;
            else {
                res += (zeroCount - 1) / 2;
                zeroCount = 0;
            }
        }
        return (res + zeroCount / 2) >= n;
    }
}
