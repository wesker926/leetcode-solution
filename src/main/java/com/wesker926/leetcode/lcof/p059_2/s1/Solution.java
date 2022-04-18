package com.wesker926.leetcode.lcof.p059_2.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/4/18
 * @description 有序双向队列
 */
public class Solution {

    Queue<Integer> valQueue;

    Deque<Integer> maxQueue;

    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     */
    public Solution() {
        valQueue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
    }

    public void push_back(int value) {
        valQueue.offer(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
    }

    @SuppressWarnings("all")
    public int pop_front() {
        if (valQueue.isEmpty()) {
            return -1;
        }
        // 注意Integer比较
        if (Objects.equals(valQueue.peek(), maxQueue.peekFirst())) {
            maxQueue.pollFirst();
        }
        return valQueue.poll();
    }
}
