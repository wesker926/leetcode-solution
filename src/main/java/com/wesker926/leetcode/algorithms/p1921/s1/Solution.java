package com.wesker926.leetcode.algorithms.p1921.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/9/3
 * @description 排序 + 贪心
 * 对到达时间使用计数排序（上线为n），能达到O(n)
 */
public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        for (int i = 0; i < n; i++) dist[i] = (dist[i] - 1) / speed[i] + 1;
        Arrays.sort(dist);
        for (int i = 0; i < n; i++) if (dist[i] <= i) return i;
        return n;
    }
}
