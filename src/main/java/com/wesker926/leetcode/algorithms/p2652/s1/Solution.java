package com.wesker926.leetcode.algorithms.p2652.s1;

/**
 * @author wesker.gh
 * @date 2023/10/17
 * @description 枚举
 */
public class Solution {
    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++)
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) ans += i;
        return ans;
    }
}
