package com.wesker926.leetcode.algorithms.p0873.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/7/9
 * @description DP + 剪枝
 * 以i,j为波那契式的倒数1，2位
 * 剪枝：k的值不能大于j的值。
 * 剪枝：j位置的理论最大长度（j+2）小于当前最大ans时，可以不继续计算。（不知道如何证明，代码里不加了）
 */
public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, ans = 0;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[i] - arr[j] < arr[j]; j--) {
                int k = idxMap.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[i][j] = Math.max(3, dp[j][k] + 1);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
