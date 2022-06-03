package com.wesker926.leetcode.algorithms.p0829.s1;

/**
 * @author wesker.gh
 * @date 2022/6/3
 * @description 数学
 * 请分析下为什么上面的比下面的要快？
 */
public class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 0, count;
        for (n *= 2, count = 1; count * (count + 1) <= n; count++) {
            if (n % count != 0) {
                continue;
            }
            if (((n / count + 1 - count) & 1) == 0) {
                ans++;
            }
        }
        return ans;
//        int maxCount = (int) ((Math.sqrt((long) n * 8 + 1) - 1) / 2), ans = 0;
//        for (int c = 1; c <= maxCount; c++) {
//            double from = ((double) n * 2 / c + 1 - c) / 2;
//            if (from == (int) from) {
//                ans++;
//            }
//        }
//        return ans;
    }
}
