package com.wesker926.leetcode.algorithms.p1732.s1;

/**
 * @author wesker.gh
 * @date 2022/11/19
 * @description 遍历
 * 本质上是求前缀和的最大值
 */
public class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0, cur = 0;
        for (int diff : gain) {
            cur += diff;
            max = Math.max(max, cur);
        }
        return max;
    }
}
