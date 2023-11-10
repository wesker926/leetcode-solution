package com.wesker926.leetcode.algorithms.p2300.s2;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/11/10
 * @description 排序 + 二分
 */
public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length, n = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = n - binary(potions, (success - 1) / spells[i] + 1);
        }
        return ans;
    }

    private int binary(int[] arr, long t) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (arr[m] < t) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
}
