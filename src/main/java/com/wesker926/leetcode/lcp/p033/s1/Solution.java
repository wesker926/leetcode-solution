package com.wesker926.leetcode.lcp.p033.s1;

/**
 * @author wesker.gh
 * @date 2023/5/21
 * @description 枚举
 * 枚举蓄水次数K
 * <p>
 * 另一种写法是用堆
 */
public class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length, max = 0, res = Integer.MAX_VALUE;
        for (int i : vat) max = Math.max(max, i);
        if (max == 0) return 0;
        for (int k = 1, t = 0; k <= max && k < res; k++, t = 0) {
            for (int i = 0; i < n; i++) t += Math.max(0, (vat[i] - 1) / k + 1 - bucket[i]);
            res = Math.min(res, k + t);
        }
        return res;
    }
}
