package com.wesker926.leetcode.algorithms.p0045.s1;

/**
 * @author wesker.gh
 * @date 2022/4/30
 * @description 贪心
 */
public class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        for (int i = 0, j = 0, max; j < nums.length - 1; j = max) {
            ans++;
            for (max = 0; i <= j; i++) {
                max = Math.max(max, i + nums[i]);
            }
        }
        return ans;
    }
}
