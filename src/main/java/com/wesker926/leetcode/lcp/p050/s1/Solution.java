package com.wesker926.leetcode.lcp.p050.s1;

/**
 * @author wesker.gh
 * @date 2023/9/15
 * @description 模拟
 */
public class Solution {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] op : operations) {
            int delta = gem[op[0]] >> 1;
            gem[op[1]] += delta;
            gem[op[0]] -= delta;
        }
        int max = gem[0], min = max;
        for (int count : gem) {
            max = Math.max(max, count);
            min = Math.min(min, count);
        }
        return max - min;
    }
}
