package com.wesker926.leetcode.algorithms.p2735.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/12/28
 * @description 枚举
 * 有更优方法，比较难
 * https://leetcode.cn/problems/collecting-chocolates/solutions/2580148/shou-ji-qiao-ke-li-by-leetcode-solution-bjyp/?envType=daily-question&envId=2023-12-28
 */
public class Solution {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        long res = Long.MAX_VALUE;
        long[] dp = new long[n];
        Arrays.fill(dp, res);
        for (int c = 0; c < n; c++) {
            long cur = (long) c * x;
            for (int i = 0; i < n; i++) {
                dp[i] = Math.min(dp[i], nums[(i + c) % n]);
                cur += dp[i];
            }
            res = Math.min(res, cur);
        }
        return res;
    }
}
