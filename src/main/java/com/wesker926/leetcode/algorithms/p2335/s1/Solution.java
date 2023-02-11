package com.wesker926.leetcode.algorithms.p2335.s1;

/**
 * @author wesker.gh
 * @date 2023/2/11
 * @description 数学
 * 跟主站-p1753是同类问题
 */
public class Solution {
    public int fillCups(int[] amount) {
        int max = Math.max(amount[0], Math.max(amount[1], amount[2])), sum = amount[0] + amount[1] + amount[2];
        return max >= sum - max ? max : (sum + 1) / 2;
    }
}
