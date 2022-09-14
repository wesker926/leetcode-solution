package com.wesker926.leetcode.algorithms.p1619.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/9/14
 * @description 排序
 * 简单题简单做
 * 可用大小顶堆解
 * 可用快速选择解
 */
public class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length, trim = n / 20, ans = 0;
        Arrays.sort(arr);
        for (int i = trim; i < n - trim; i++) {
            ans += arr[i];
        }
        return ((double) ans) / (n - trim * 2);
    }
}
