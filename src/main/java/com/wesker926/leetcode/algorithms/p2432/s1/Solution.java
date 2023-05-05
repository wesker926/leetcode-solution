package com.wesker926.leetcode.algorithms.p2432.s1;

/**
 * @author wesker.gh
 * @date 2023/5/5
 * @description 遍历
 */
public class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int ans = logs[0][0], max = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int cur = logs[i][1] - logs[i - 1][1];
            if (cur > max) {
                max = cur;
                ans = logs[i][0];
            } else if (cur == max && logs[i][0] < ans) {
                ans = logs[i][0];
            }
        }
        return ans;
    }
}
