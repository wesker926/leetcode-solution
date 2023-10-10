package com.wesker926.leetcode.algorithms.p2731.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/10/10
 * @description 排序 + 前缀和
 * 机器人没有区别，因此可以忽略碰撞！
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length, ans = 0;
        long[] pre = new long[n];
        for (int i = 0; i < n; i++) pre[i] = (long) nums[i] + (s.charAt(i) == 'R' ? d : -d);
        Arrays.sort(pre);
        for (int i = 1; i < n; i++) {
            ans = (int) ((ans + ((pre[i] - pre[i - 1]) * i % MOD) * (n - i) % MOD) % MOD);
        }
        return ans;
    }
}
