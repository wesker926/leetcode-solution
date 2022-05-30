package com.wesker926.leetcode.algorithms.p0239.s1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/5/30
 * @description 有序双向队列
 * 同lcof-p059_1
 */
public class Solution {
    @SuppressWarnings("all")
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k >= nums.length) {
            return new int[]{Arrays.stream(nums).max().orElse(0)};
        }
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() <= i - k) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && nums[deque.peekFirst()] <= nums[i]) {
                deque.pollFirst();
            }
            deque.offerFirst(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekLast()];
            }
        }
        return ans;
    }
}
