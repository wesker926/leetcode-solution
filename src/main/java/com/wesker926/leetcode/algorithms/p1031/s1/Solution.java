package com.wesker926.leetcode.algorithms.p1031.s1;

/**
 * @author wesker.gh
 * @date 2023/4/26
 * @description 前缀和 + DP
 */
public class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length, ans = 0;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int max1 = 0, max2 = 0;
        for (int i = firstLen + secondLen - 1, j = i - secondLen, k = i - firstLen; i < n; i++, j++, k++) {
            max1 = Math.max(max1, pre[j + 1] - pre[j - firstLen + 1]);
            max2 = Math.max(max2, pre[k + 1] - pre[k - secondLen + 1]);
            ans = Math.max(ans, Math.max(pre[i + 1] - pre[i + 1 - firstLen] + max2, pre[i + 1] - pre[i + 1 - secondLen] + max1));
        }
        return ans;
    }
}
