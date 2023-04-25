package com.wesker926.leetcode.algorithms.p2418.s1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wesker.gh
 * @date 2023/4/25
 * @description 排序
 * 内置排序
 */
public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(i -> heights[i]));
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = names[idx[n - 1 - i]];
        }
        return ans;
    }
}
