package com.wesker926.leetcode.algorithms.p2520.s1;

/**
 * @author wesker.gh
 * @date 2023/10/26
 * @description 模拟
 */
public class Solution {
    public int countDigits(int num) {
        int cnt = 0;
        for (int n = num; n > 0; n /= 10) {
            if (num % (n % 10) == 0) cnt++;
        }
        return cnt;
    }
}
