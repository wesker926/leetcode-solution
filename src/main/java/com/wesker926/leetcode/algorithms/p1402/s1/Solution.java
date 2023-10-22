package com.wesker926.leetcode.algorithms.p1402.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/10/22
 * @description 贪心
 * 排序 + 前缀和
 */
public class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length, ans = 0, cur = 0;
        Arrays.sort(satisfaction);
        for (int i = n - 1; i >= 0; i--) {
            cur += satisfaction[i];
            if (i > 0) satisfaction[i - 1] += satisfaction[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
