package com.wesker926.leetcode.algorithms.p1652.s1;

/**
 * @author wesker.gh
 * @date 2022/9/24
 * @description 滑动窗口 + 取模映射
 * 前缀和数组需要O(n)空间，取模映射不需要
 */
public class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        int sum = 0, abs = Math.abs(k), p = k > 0 ? 1 : -1;
        for (int i = 0; i < abs; i++) {
            sum += code[i];
        }
        for (int i = k > 0 ? 0 : abs - 1, j, c = 0; c < n; c++) {
            j = (i + k + n) % n;
            sum += code[j] - code[i];
            ans[i] = sum;
            i = (i + p + n) % n;
        }
        return ans;
    }
}
