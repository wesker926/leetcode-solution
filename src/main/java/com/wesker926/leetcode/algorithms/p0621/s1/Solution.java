package com.wesker926.leetcode.algorithms.p0621.s1;

import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2022/5/30
 * @description 堆模拟
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int count : taskCount) {
            if (count != 0) {
                queue.offer(count);
            }
        }
        int[] cache = new int[n + 1];
        int layer = 0, layerCount = 0;
        while (!queue.isEmpty()) {
            layerCount = 0;
            for (int i = 0; i < cache.length && !queue.isEmpty(); i++, layerCount++) {
                cache[i] = queue.poll();
            }
            int sub = queue.isEmpty() ? 1 : cache[layerCount - 1] - queue.peek() + 1;
            for (int i = 0; i < layerCount; i++) {
                if ((cache[i] -= sub) > 0) {
                    queue.offer(cache[i]);
                }
            }
            layer += sub;
        }
        return (layer - 1) * (n + 1) + layerCount;
    }
}
