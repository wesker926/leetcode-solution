package com.wesker926.leetcode.algorithms.p0062.s2;

/**
 * @author wesker.gh
 * @date 2022/5/2
 * @description 数学组合数
 * 可以保证每一步都整除，注意溢出。
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
