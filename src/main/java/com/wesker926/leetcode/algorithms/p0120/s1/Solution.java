package com.wesker926.leetcode.algorithms.p0120.s1;

import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/17
 * @description DP（从上往下）
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i <= triangle.size(); i++) {
            for (int j = i; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i - 1).get(j - 1);
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
