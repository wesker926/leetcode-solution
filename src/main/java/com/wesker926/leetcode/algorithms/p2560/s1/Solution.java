package com.wesker926.leetcode.algorithms.p2560.s1;

/**
 * @author wesker.gh
 * @date 2023/9/19
 * @description 二分
 * 检查过程可以简化为count+visited，因为能早抢就抢总是最优的
 */
public class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 0, r = (int) 1e9 + 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (check(nums, k, m)) r = m - 1;
            else l = m + 1;
        }
        return l;
    }

    private boolean check(int[] nums, int k, int tar) {
        int select = 0, notSelect = 0;
        for (int num : nums) {
            if (num <= tar) {
                int t = select;
                select = notSelect + 1;
                notSelect = t;
            } else {
                notSelect = Math.max(notSelect, select);
                select = notSelect;
            }
        }
        return Math.max(select, notSelect) >= k;
    }
}
