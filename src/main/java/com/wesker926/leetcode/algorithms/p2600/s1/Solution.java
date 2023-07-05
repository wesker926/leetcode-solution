package com.wesker926.leetcode.algorithms.p2600.s1;

/**
 * @author wesker.gh
 * @date 2023/7/5
 * @description 贪心
 */
public class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        return Math.min(numOnes, k) - Math.max(k - numOnes - numZeros, 0);
    }
}
