package com.wesker926.leetcode.lcof.p030.s1;

import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2021/10/26
 * @description stack
 */
public class Solution {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
    static class MinStack {

        private final LinkedList<Integer> val;

        private final LinkedList<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            val = new LinkedList<>();
            min = new LinkedList<>();
        }

        public void push(int x) {
            val.push(x);
            min.push(min.isEmpty() || x <= min.peekFirst() ? x : min.peekFirst());
        }

        public void pop() {
            val.pop();
            min.pop();
        }

        public int top() {
            return val.isEmpty() ? -1 : val.peekFirst();
        }

        public int min() {
            return min.isEmpty() ? -1 : min.peekFirst();
        }
    }
}
