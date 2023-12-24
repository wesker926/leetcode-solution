package com.wesker926.leetcode.algorithms.p1954.s1;

/**
 * @author wesker.gh
 * @date 2023/12/24
 * @description 二分
 */
public class Solution {
    public long minimumPerimeter(long neededApples) {
        long l = 1, r = 62996;
        while (l <= r) {
            long m = (l + r) >> 1;
            long c = m * (m + 1) * (m * 2 + 1) * 2;
            if (c < neededApples) l = m + 1;
            else r = m - 1;
        }
        return l << 3;
    }
}
