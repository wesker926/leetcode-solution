package com.wesker926.leetcode.algorithms.p2530.s1;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2023/10/18
 * @description 堆
 */
public class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((i, j) -> j - i);
        for (int num : nums) queue.offer(num);
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += queue.peek();
            queue.offer((queue.poll() + 2) / 3);
        }
        return ans;
    }
}
