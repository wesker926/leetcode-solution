package com.wesker926.leetcode.algorithms.p0875.s1;

/**
 * @author wesker.gh
 * @date 2022/6/7
 * @description 二分
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0, max = 0;
        for (int pile : piles) {
            sum += pile;
            max = Math.max(max, pile);
        }
        int l = Math.max((int) (sum / h), 1), r = (int) max, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (canFinish(piles, m, h)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean canFinish(int[] nums, int k, int h) {
        int need = 0;
        for (int num : nums) {
            need += (num - 1) / k + 1;
        }
        return need <= h;
    }
}
