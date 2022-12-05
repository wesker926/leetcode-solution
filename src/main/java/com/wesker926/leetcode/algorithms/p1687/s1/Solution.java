package com.wesker926.leetcode.algorithms.p1687.s1;

/**
 * @author wesker.gh
 * @date 2022/12/5
 * @description 前缀和 + DP + 单调栈
 * 限制条件的计算可以使用前缀和优化
 * DP的转移方程：dp[i] = min(dp[j] + preT(i) - preT[j + 1]) + 2
 * 通过提取方程中j相关参数，可以使用单调栈优化
 */
public class Solution {
    @SuppressWarnings("all")
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] preT = new int[n + 1];
        long[] preW = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int[] box = boxes[i];
            preW[i + 1] = preW[i] + box[1];
            preT[i + 1] = preT[i] + (i != 0 && box[0] != boxes[i - 1][0] ? 1 : 0);
        }

        int[] dp = new int[n + 1];
        int[] queue = new int[n + 1];
        int head = 0, tail = 1;
        for (int i = 1; i <= n; i++) {
            while (i - queue[head] > maxBoxes || preW[i] - preW[queue[head]] > maxWeight) {
                head++;
            }
            dp[i] = dp[queue[head]] - preT[queue[head] + 1] + preT[i] + 2;
            if (i != n) {
                while (head != tail && dp[i] - preT[i + 1] <= dp[queue[tail - 1]] - preT[queue[tail - 1] + 1]) {
                    tail--;
                }
                queue[tail++] = i;
            }
        }
        return dp[n];
    }
}
