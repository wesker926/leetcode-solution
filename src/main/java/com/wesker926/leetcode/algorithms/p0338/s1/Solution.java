package com.wesker926.leetcode.algorithms.p0338.s1;

/**
 * @author wesker.gh
 * @date 2022/5/27
 * @description DP（最低设置位）
 * 移除lowbit，i & (i - 1)
 * 注：ans[i - 1] - ans[(i & (-i)) - 1] 等价于 ans[i & (i - 1)]
 */
public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
}
