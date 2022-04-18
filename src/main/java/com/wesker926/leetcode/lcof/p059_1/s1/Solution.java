package com.wesker926.leetcode.lcof.p059_1.s1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/4/18
 * @description 有序双向队列
 */
public class Solution {
    @SuppressWarnings("all")
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }
}
