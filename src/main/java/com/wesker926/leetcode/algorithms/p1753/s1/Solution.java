package com.wesker926.leetcode.algorithms.p1753.s1;

/**
 * @author wesker.gh
 * @date 2022/12/21
 * @description 贪心
 * 如果max大于其他两个之和other，得分必然是other
 * 如果max不大于other，此时sum为偶数时可以拿完，sum为奇数时剩一个，得分sum/2
 */
public class Solution {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c, max = Math.max(a, Math.max(b, c)), other = sum - max;
        return max > other ? other : sum / 2;
    }
}
