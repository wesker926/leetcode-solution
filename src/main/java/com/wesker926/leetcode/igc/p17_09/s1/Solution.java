package com.wesker926.leetcode.igc.p17_09.s1;

/**
 * @author wesker.gh
 * @date 2022/9/28
 * @description 丑数
 * DP
 */
public class Solution {

    public int getKthMagicNumber(int k) {
        int[] nums = new int[k];
        nums[0] = 1;
        int idx3 = 0, idx5 = 0, idx7 = 0;
        for (int i = 1; i < k; i++) {
            int cur3 = 3 * nums[idx3], cur5 = 5 * nums[idx5], cur7 = 7 * nums[idx7];
            nums[i] = Math.min(cur3, Math.min(cur5, cur7));
            if (cur3 == nums[i]) {
                idx3++;
            }
            if (cur5 == nums[i]) {
                idx5++;
            }
            if (cur7 == nums[i]) {
                idx7++;
            }
        }
        return nums[k - 1];
    }
}
