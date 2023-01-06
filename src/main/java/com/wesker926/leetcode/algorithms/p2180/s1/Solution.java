package com.wesker926.leetcode.algorithms.p2180.s1;

/**
 * @author wesker.gh
 * @date 2023/1/6
 * @description 数学
 * 每10个数必然存在5个，然后处理个位
 * 需要减去0这个数
 */
public class Solution {
    public int countEven(int num) {
        int low = num % 10, high = num / 10, sum = 0;
        for (int i = high; i > 0; i /= 10) {
            sum += i % 10;
        }
        return high * 5 + (low + 2 - (sum & 1)) / 2 - 1;
    }
}
