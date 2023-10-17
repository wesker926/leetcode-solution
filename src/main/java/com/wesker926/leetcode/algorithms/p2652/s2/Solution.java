package com.wesker926.leetcode.algorithms.p2652.s2;

/**
 * @author wesker.gh
 * @date 2023/10/17
 * @description 容斥原理
 * https://leetcode.cn/problems/sum-multiples/solutions/2470653/bei-shu-qiu-he-by-leetcode-solution-kumf/?envType=daily-question&envId=2023-10-17
 */
public class Solution {
    private int sum(int a, int n) {
        return (a + n / a * a) * (n / a) / 2;
    }

    public int sumOfMultiples(int n) {
        return sum(3, n) + sum(5, n) + sum(7, n) -
                sum(15, n) - sum(21, n) - sum(35, n) + sum(105, n);
    }
}
