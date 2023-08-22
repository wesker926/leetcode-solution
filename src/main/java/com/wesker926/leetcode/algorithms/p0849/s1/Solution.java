package com.wesker926.leetcode.algorithms.p0849.s1;

/**
 * @author wesker.gh
 * @date 2023/8/22
 * @description 贪心模拟
 */
public class Solution {
    public int maxDistToClosest(int[] seats) {
        int ans = 0, count = 0, n = seats.length, i = 0;
        for (; i < n && seats[i] == 0; i++) ans++;
        for (i++; i < n; i++) {
            if (seats[i] == 0) count++;
            else {
                ans = Math.max(ans, (count + 1) >> 1);
                count = 0;
            }
        }
        return Math.max(ans, count);
    }
}
