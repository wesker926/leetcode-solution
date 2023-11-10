package com.wesker926.leetcode.algorithms.p2300.s1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wesker.gh
 * @date 2023/11/10
 * @description 排序 + 双指针
 */
public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length, n = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[m];
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) idx[i] = i;
        Arrays.sort(idx, Comparator.comparingInt(i -> spells[i]));
        for (int i = 0, j = n - 1; i < m; i++) {
            long t = (success - 1) / spells[idx[i]] + 1;
            while (j >= 0 && potions[j] >= t) j--;
            ans[idx[i]] = n - j - 1;
        }
        return ans;
    }
}
