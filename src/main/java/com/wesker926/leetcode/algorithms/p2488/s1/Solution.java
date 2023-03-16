package com.wesker926.leetcode.algorithms.p2488.s1;

/**
 * @author wesker.gh
 * @date 2023/3/16
 * @description 前缀和
 * 依然是前缀和 + 二元逆推性质（两数之和）的经典组合
 */
public class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length, ans = 0, idx = -1, pre = n;
        int[] count = new int[n * 2 + 1];
        for (int i = 0; i < n; i++) {
            if (idx < 0) {
                if (nums[i] == k) {
                    idx = i;
                } else {
                    continue;
                }
            }
            count[pre]++;
            if (i < n - 1) {
                pre += nums[i + 1] < k ? -1 : 1;
            }
        }
        for (pre = 0; idx >= 0; idx--) {
            ans += count[n - pre] + count[n + 1 - pre];
            if (idx > 0) {
                pre += nums[idx - 1] < k ? -1 : 1;
            }
        }
        return ans;
    }
}
