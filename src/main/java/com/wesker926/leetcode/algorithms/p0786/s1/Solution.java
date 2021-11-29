package com.wesker926.leetcode.algorithms.p0786.s1;

import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2021/11/29
 * @description 优先级队列（堆）
 */
public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> arr[o1[0]] * arr[o2[1]] - arr[o2[0]] * arr[o1[1]]);
        for (int i = 1; i < n; i++) {
            queue.offer(new int[]{0, i});
        }

        int[] cur = null;
        for (int i = 0; i < k; i++) {
            cur = queue.poll();
            if (cur[1] - cur[0] > 1) {
                queue.offer(new int[]{cur[0] + 1, cur[1]});
            }
        }
        return new int[]{arr[cur[0]], arr[cur[1]]};
    }
}
