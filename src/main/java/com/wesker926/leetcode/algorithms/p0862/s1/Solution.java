package com.wesker926.leetcode.algorithms.p0862.s1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/10/26
 * @description 前缀和数组 + 单调双端队列
 * 1.构造前缀和
 * 2.从左端开始找符合的情况并更新res
 * 3.维持队列严格单调增
 */
public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int res = n + 1;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            long cur = preSum[i];
            while (!queue.isEmpty() && cur - preSum[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && preSum[queue.peekLast()] >= cur) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }
}
