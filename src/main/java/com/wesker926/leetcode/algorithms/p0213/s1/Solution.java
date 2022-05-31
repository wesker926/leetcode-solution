package com.wesker926.leetcode.algorithms.p0213.s1;

/**
 * @author wesker.gh
 * @date 2022/5/31
 * @description DP
 * 进行两次dp，范围分别是掐头[1,n-1]去尾[0,n-2]
 */
public class Solution {
    public int rob(int[] nums) {
        return nums.length == 1 ? nums[0] :
                Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
    }

    private int dp(int[] nums, int st, int ed) {
        int select = 0, notSelect = 0;
        for (int i = st; i <= ed; i++) {
            int temp = select;
            select = notSelect + nums[i];
            notSelect = Math.max(temp, notSelect);
        }
        return Math.max(select, notSelect);
    }
}
