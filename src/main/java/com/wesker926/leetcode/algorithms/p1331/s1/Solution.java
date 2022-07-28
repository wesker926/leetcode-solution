package com.wesker926.leetcode.algorithms.p1331.s1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wesker.gh
 * @date 2022/7/28
 * @description 排序
 * 不知道为什么这么慢
 */
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(i -> arr[i]));
        int[] ans = new int[n];
        for (int i = 0, j = 0, k = 1; j < n; j++) {
            if (j == n - 1 || arr[idx[j]] != arr[idx[j + 1]]) {
                for (; i <= j; i++) {
                    ans[idx[i]] = k;
                }
                k++;
            }
        }
        return ans;
    }
}
