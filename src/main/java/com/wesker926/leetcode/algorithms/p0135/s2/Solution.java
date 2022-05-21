package com.wesker926.leetcode.algorithms.p0135.s2;

/**
 * @author wesker.gh
 * @date 2022/5/21
 * @description 两次遍历
 * 双向遍历，取同位置的较大值
 */
public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 1;
        }
        int sum = Math.max(right[0], 1);
        for (int i = 1, left = 1; i < n; i++) {
            left = ratings[i] > ratings[i - 1] ? left + 1 : 1;
            sum += Math.max(left, right[i]);
        }
        return sum;
    }
}
