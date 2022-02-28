package com.wesker926.leetcode.algorithms.p1601.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/2/28
 * @description 数据量小直接暴力枚举（大数据量超纲了，参考最小费用最大流）
 */
public class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] counts = new int[n];
        int ans = 0, cur;
        outer:
        for (int mask = 0; mask < (1 << requests.length); mask++) {
            if ((cur = Integer.bitCount(mask)) <= ans) {
                continue;
            }
            Arrays.fill(counts, 0);
            for (int i = 0; i < requests.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    counts[requests[i][0]]--;
                    counts[requests[i][1]]++;
                }
            }
            for (int c : counts) {
                if (c != 0) {
                    continue outer;
                }
            }
            ans = cur;
        }
        return ans;
    }
}
