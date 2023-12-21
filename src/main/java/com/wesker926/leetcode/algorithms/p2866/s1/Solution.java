package com.wesker926.leetcode.algorithms.p2866.s1;

import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/12/21
 * @description 单调栈
 * 左右双向各一次单调栈
 * 循环结构还可以继续优化
 */
public class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        int[] mh = new int[n];
        for (int i = 0; i < n; i++) mh[i] = maxHeights.get(i);

        int[][] pre = new int[n][2];
        for (int i = 0; i < n; i++) {
            pre[i][0] = -1;
            pre[i][1] = n;
        }
        int[] sk = new int[n];
        for (int i = n - 1, idx = 0; i >= 0; i--) {
            for (; idx > 0 && mh[sk[idx - 1]] > mh[i]; idx--) pre[sk[idx - 1]][0] = i;
            sk[idx++] = i;
        }
        for (int i = 0, idx = 0; i < n; i++) {
            for (; idx > 0 && mh[sk[idx - 1]] > mh[i]; idx--) pre[sk[idx - 1]][1] = i;
            sk[idx++] = i;
        }

        long res = 0;
        long[][] sum = new long[n][2];
        for (int i = 0; i < n; i++) {
            long pi = pre[i][0], pv = pi < 0 ? 0 : sum[(int) pi][0];
            sum[i][0] = pv + mh[i] * (i - pi);
        }
        for (int i = n - 1; i >= 0; i--) {
            long pi = pre[i][1], pv = pi >= n ? 0 : sum[(int) pi][1];
            sum[i][1] = pv + mh[i] * (pi - i);
        }
        for (int i = 0; i < n; i++) res = Math.max(res, sum[i][0] + sum[i][1] - mh[i]);
        return res;
    }
}
