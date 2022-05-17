package com.wesker926.leetcode.algorithms.p0120.s2;

import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/17
 * @description DP（从下往上）
 * 好处：不需要额外设置边界，最后不需要计算min
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size(); i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i - 1).get(j);
            }
        }
        return dp[0];
    }
}
