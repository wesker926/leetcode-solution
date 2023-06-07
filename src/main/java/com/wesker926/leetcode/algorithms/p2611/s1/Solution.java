package com.wesker926.leetcode.algorithms.p2611.s1;

import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2023/6/7
 * @description 小顶堆
 */
public class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0, n = reward1.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            queue.offer(reward1[i] - reward2[i]);
            if (queue.size() > k) queue.poll();
        }
        for (int diff : queue) ans += diff;
        return ans;
    }
}
