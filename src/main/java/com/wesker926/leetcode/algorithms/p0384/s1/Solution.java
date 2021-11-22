package com.wesker926.leetcode.algorithms.p0384.s1;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wesker.gh
 * @date 2021/11/22
 * @description Fisher-Yates 洗牌算法
 */
public class Solution {

    private final int[] origin;

    private final Random random;

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    public Solution(int[] nums) {
        this.origin = Arrays.copyOf(nums, nums.length);
        this.random = new Random();
    }

    public int[] reset() {
        return Arrays.copyOf(this.origin, this.origin.length);
    }

    public int[] shuffle() {
        int[] copy = Arrays.copyOf(this.origin, this.origin.length);
        for (int i = 0; i < copy.length; i++) {
            swap(i, random.nextInt(copy.length - i) + i, copy);
        }
        return copy;
    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}