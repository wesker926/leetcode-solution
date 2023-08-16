package com.wesker926.leetcode.algorithms.p2682.s1;

/**
 * @author wesker.gh
 * @date 2023/8/16
 * @description 模拟
 * 只有模拟解法
 */
public class Solution {
    public int[] circularGameLosers(int n, int k) {
        int count = n, idx = 0;
        boolean[] table = new boolean[n];
        for (int i = 0, j = 0; !table[i]; j += k, i = (i + j) % n) {
            table[i] = true;
            count--;
        }
        int[] ans = new int[count];
        for (int i = 0; i < n; i++) if (!table[i]) ans[idx++] = i + 1;
        return ans;
    }
}
