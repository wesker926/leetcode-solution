package com.wesker926.leetcode.algorithms.p0933.s1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/5/6
 * @description 队列
 */
public class Solution {

    private final Queue<Integer> queue;

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
    public Solution() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty() && queue.peek() + 3000 < t) {
            queue.poll();
        }
        return queue.size();
    }
}
