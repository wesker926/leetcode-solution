package com.wesker926.leetcode.algorithms.p1281.s1;

/**
 * @author wesker.gh
 * @date 2023/8/9
 * @description 模拟
 */
public class Solution {
    public int subtractProductAndSum(int n) {
        int mul = 1, sum = 0;
        for (int cur; n > 0; mul *= cur, sum += cur, n /= 10)
            cur = n % 10;
        return mul - sum;
    }
}
