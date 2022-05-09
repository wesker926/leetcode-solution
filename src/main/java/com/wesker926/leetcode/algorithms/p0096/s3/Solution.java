package com.wesker926.leetcode.algorithms.p0096.s3;

/**
 * @author wesker.gh
 * @date 2022/5/9
 * @description 数学
 * 卡塔兰数：C(n+1) = C(n) * 2 * (2 * n + 1) / (n + 2), C(0) = 1。
 */
public class Solution {
    public int numTrees(int n) {
        long ans = 1;
        for (long i = 0; i < n; i++) {
            ans = ans * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) ans;
    }
}
