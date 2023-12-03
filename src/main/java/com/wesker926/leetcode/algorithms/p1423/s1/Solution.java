package com.wesker926.leetcode.algorithms.p1423.s1;

/**
 * @author wesker.gh
 * @date 2023/12/3
 * @description 滑动窗口
 * 逆向思维O(n)
 * 正向思维可做到O(k)
 */
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, sum = 0, cur = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += cardPoints[i];
            cur += cardPoints[i] - (i < n - k ? 0 : cardPoints[i - n + k]);
            if (i + 1 >= n - k) min = Math.min(min, cur);
        }
        return sum - min;
    }
}
