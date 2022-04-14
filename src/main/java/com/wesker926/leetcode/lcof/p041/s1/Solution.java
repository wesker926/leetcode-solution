package com.wesker926.leetcode.lcof.p041.s1;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/4/14
 * @description 双堆
 */
public class Solution {

    private final Queue<Integer> minHeap;

    private final Queue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public Solution() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() != minHeap.size()) {
            return maxHeap.peek();
        } else {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
