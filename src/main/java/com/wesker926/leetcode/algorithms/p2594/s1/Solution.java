package com.wesker926.leetcode.algorithms.p2594.s1;

/**
 * @author wesker.gh
 * @date 2023/9/7
 * @description 二分
 * 这题频率计数优化很有效果
 */
public class Solution {
    public long repairCars(int[] ranks, int cars) {
        int maxRank = 0;
        for (int rank : ranks) maxRank = Math.max(maxRank, rank);
        int[] freq = new int[maxRank + 1];
        for (int rank : ranks) freq[rank]++;
        long l = 1, r = (long) ranks[0] * cars * cars;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (check(freq, m, cars)) r = m - 1;
            else l = m + 1;
        }
        return l;
    }

    private boolean check(int[] freq, double time, long car) {
        long count = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            count += (long) Math.sqrt(time / i) * freq[i];
        }
        return count >= car;
    }
}
