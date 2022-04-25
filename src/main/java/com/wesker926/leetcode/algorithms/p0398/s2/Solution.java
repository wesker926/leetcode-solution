package com.wesker926.leetcode.algorithms.p0398.s2;

/**
 * @author wesker.gh
 * @date 2022/4/25
 * @description 水塘抽样
 */
public class Solution {

    private final int[] nums;

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int param_1 = obj.pick(target);
     */
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int ans = 0;
        for (int i = 0, idx = 1; i < nums.length; i++) {
            if (nums[i] == target && (int) (Math.random() * idx++) == 0) {
                ans = i;
            }
        }
        return ans;
    }
}
