package com.wesker926.leetcode.algorithms.p2034.s2;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/1/23
 * @description 优先级队列（堆）
 */
public class Solution {

    private int cur;

    private final Map<Integer, Integer> map;

    private final Queue<int[]> minQueue;

    private final Queue<int[]> maxQueue;

    /**
     * Your StockPrice object will be instantiated and called as such:
     * StockPrice obj = new StockPrice();
     * obj.update(timestamp,price);
     * int param_2 = obj.current();
     * int param_3 = obj.maximum();
     * int param_4 = obj.minimum();
     */
    public Solution() {
        cur = 0;
        map = new HashMap<>();
        minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        maxQueue = new PriorityQueue<>((a1, a2) -> a2[1] - a1[1]);
    }

    public void update(int timestamp, int price) {
        if (map.getOrDefault(timestamp, 0) == price) {
            return;
        }
        map.put(timestamp, price);
        cur = Math.max(cur, timestamp);

        int[] node = new int[]{timestamp, price};
        minQueue.offer(node);
        maxQueue.offer(node);
    }

    public int current() {
        return map.getOrDefault(cur, 0);
    }

    public int maximum() {
        return getTop(maxQueue);
    }

    public int minimum() {
        return getTop(minQueue);
    }

    private int getTop(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] top = queue.peek();
            if (map.get(top[0]) != top[1]) {
                queue.poll();
                continue;
            }
            return top[1];
        }
        return 0;
    }
}
