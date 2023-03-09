package com.wesker926.leetcode.algorithms.p2379.s1;

/**
 * @author wesker.gh
 * @date 2023/3/9
 * @description 滑动窗口
 */
public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length(), min = n, cur = 0;
        for (int i = 0; i < n; i++) {
            cur += blocks.charAt(i) == 'W' ? 1 : 0;
            if (i >= k - 1) {
                min = Math.min(min, cur);
                cur -= blocks.charAt(i - k + 1) == 'W' ? 1 : 0;
            }
        }
        return min;
    }
}
