package com.wesker926.leetcode.algorithms.p2865.s1;

import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2024/1/24
 * @description 单调栈
 * 和2866的差别就只有数据规模（本题更小），用相同的写法没有问题
 */
public class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        int[] mh = new int[n];
        for (int i = 0; i < n; i++) mh[i] = maxHeights.get(i);

        int[][] pre = new int[2][n];
        Arrays.fill(pre[0], -1);
        Arrays.fill(pre[1], n);

        int[] sk = new int[n];
        for (int i = n - 1, idx = 0; i >= 0; i--) {
            for (; idx > 0 && mh[sk[idx - 1]] > mh[i]; idx--) pre[0][sk[idx - 1]] = i;
            sk[idx++] = i;
        }
        for (int i = 0, idx = 0; i < n; i++) {
            for (; idx > 0 && mh[sk[idx - 1]] > mh[i]; idx--) pre[1][sk[idx - 1]] = i;
            sk[idx++] = i;
        }

        long res = 0;
        long[][] sum = new long[2][n];
        for (int i = 0; i < n; i++) {
            long pi = pre[0][i], pv = pi < 0 ? 0 : sum[0][(int) pi];
            sum[0][i] = pv + mh[i] * (i - pi);
        }
        for (int i = n - 1; i >= 0; i--) {
            long pi = pre[1][i], pv = pi >= n ? 0 : sum[1][(int) pi];
            sum[1][i] = pv + mh[i] * (pi - i);
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, sum[0][i] + sum[1][i] - mh[i]);
        }
        return res;
    }
}
