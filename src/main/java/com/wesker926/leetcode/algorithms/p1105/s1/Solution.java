package com.wesker926.leetcode.algorithms.p1105.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/4/23
 * @description DP
 * 注意题目是按顺序不是任意顺序
 */
public class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int curWidth = 0, curHeight = 0;
            for (int j = i; j >= 0; j--) {
                if ((curWidth += books[j][0]) > shelfWidth) {
                    break;
                }
                curHeight = Math.max(curHeight, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], curHeight + dp[j]);
            }
        }
        return dp[n];
    }
}
