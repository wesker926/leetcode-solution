package com.wesker926.leetcode.algorithms.p0598.s1;

/**
 * @author wesker.gh
 * @date 2021/11/7
 * @description 最小值
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int[] min = new int[]{m, n};
        for (int[] op : ops) {
            min[0] = Math.min(min[0], op[0]);
            min[1] = Math.min(min[1], op[1]);
        }
        return min[0] * min[1];
    }
}
