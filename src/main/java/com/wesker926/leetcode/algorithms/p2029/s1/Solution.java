package com.wesker926.leetcode.algorithms.p2029.s1;

/**
 * @author wesker.gh
 * @date 2022/1/20
 * @description 博弈论
 */
public class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        if ((count[0] & 1) == 0) {
            return count[1] >= 1 && count[2] >= 1;
        }
        return Math.abs(count[1] - count[2]) > 2;
    }
}
