package com.wesker926.leetcode.algorithms.p0667.s1;

/**
 * @author wesker.gh
 * @date 2022/9/8
 * @description 交替排列
 * 思路基本都一样，无非是顺序的区别
 */
public class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        ans[0] = 1;
        int s = 2, e = n, idx = 1;
        for (int i = 0; i < k - 1; i++) {
            ans[idx++] = (i & 1) == 0 ? e-- : s++;
        }
        int i = (k & 1) == 1 ? s : e, p = i == s ? 1 : -1;
        for (; idx < n; i += p, idx++) {
            ans[idx] = i;
        }
        return ans;
    }
}
