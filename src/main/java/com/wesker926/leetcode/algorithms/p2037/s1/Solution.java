package com.wesker926.leetcode.algorithms.p2037.s1;

/**
 * @author wesker.gh
 * @date 2022/12/31
 * @description 排序（桶）
 */
@SuppressWarnings("all")
public class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int ans = 0;
        int[] bucket1 = new int[101], bucket2 = new int[101];
        for (int i = 0; i < seats.length; i++) {
            bucket1[seats[i]]++;
            bucket2[students[i]]++;
        }
        for (int i = 0, j = 0; ; ) {
            for (; i < 101 && bucket1[i] == 0; i++) ;
            for (; j < 101 && bucket2[j] == 0; j++) ;
            if (i >= 101) break;
            int count = Math.min(bucket1[i], bucket2[j]);
            ans += Math.abs(j - i) * count;
            bucket1[i] -= count;
            bucket2[j] -= count;
        }
        return ans;
    }
}
