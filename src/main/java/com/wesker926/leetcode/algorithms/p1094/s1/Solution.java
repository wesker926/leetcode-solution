package com.wesker926.leetcode.algorithms.p1094.s1;

/**
 * @author wesker.gh
 * @date 2023/12/2
 * @description 差分数组
 * 差分是前缀和的逆运算，对差分数组求前缀和即可得到原数组
 * 这题不需要线段树
 */
public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for (int[] trip : trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }
        for (int c : arr) if ((capacity -= c) < 0) return false;
        return true;
    }
}
