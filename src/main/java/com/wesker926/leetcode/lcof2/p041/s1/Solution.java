package com.wesker926.leetcode.lcof2.p041.s1;

/**
 * @author wesker.gh
 * @date 2022/7/16
 * @description 队列模拟
 */
public class Solution {

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
    private static class MovingAverage {

        private int idx;

        private int sum;

        private boolean fill;

        private final int[] queue;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            idx = 0;
            sum = 0;
            fill = false;
            queue = new int[size];
        }

        public double next(int val) {
            sum += val + (fill ? -queue[idx] : 0);
            queue[idx] = val;
            idx = (idx + 1) % queue.length;
            fill = fill || (idx == 0);
            return ((double) sum) / (fill ? queue.length : idx);
        }
    }
}
