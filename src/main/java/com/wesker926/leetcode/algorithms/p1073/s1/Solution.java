package com.wesker926.leetcode.algorithms.p1073.s1;

/**
 * @author wesker.gh
 * @date 2023/5/18
 * @description 模拟
 */
public class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length, l = Math.max(m, n) + 2;
        int[] sum = new int[l];
        for (int i = 0; i < sum.length; i++) {
            sum[i] += (m - 1 - i >= 0 ? arr1[m - 1 - i] : 0) + (n - 1 - i >= 0 ? arr2[n - 1 - i] : 0);
            if (sum[i] < 0) {
                sum[i] = 1;
                sum[i + 1]++;
                continue;
            }
            if ((sum[i] >> 1) != 0) sum[i + 1]--;
            sum[i] &= 1;
        }
        for (; l > 1 && sum[l - 1] == 0; l--) ;
        int[] ans = new int[l];
        for (int i = 0; i < l; i++) {
            ans[i] = sum[l - 1 - i];
        }
        return ans;
    }
}
