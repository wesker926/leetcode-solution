package com.wesker926.leetcode.algorithms.p0575.s1;

/**
 * @author wesker.gh
 * @date 2021/11/1
 * @description set
 */
public class Solution {
    public int distributeCandies(int[] candyType) {
        int c = 0;
        boolean[] set = new boolean[200001];
        for (int i : candyType) {
            if (!set[i + 100000]) {
                c++;
                set[i + 100000] = true;
            }
        }
        return Math.min(c, candyType.length / 2);
    }
}
