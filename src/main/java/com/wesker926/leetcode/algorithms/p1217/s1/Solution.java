package com.wesker926.leetcode.algorithms.p1217.s1;

/**
 * @author wesker.gh
 * @date 2022/7/8
 * @description 贪心
 * 返回奇偶数中较小的那个
 */
public class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        for (int p : position) {
            odd += p & 1;
        }
        return Math.min(odd, position.length - odd);
    }
}
