package com.wesker926.leetcode.lcof.p009.s1;

import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2021/10/26
 * @description stack
 */
public class Solution {

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    static class CQueue {

        private final LinkedList<Integer> f;

        private final LinkedList<Integer> s;

        public CQueue() {
            f = new LinkedList<>();
            s = new LinkedList<>();
        }

        public void appendTail(int value) {
            f.push(value);
        }

        public int deleteHead() {
            if (s.isEmpty()) {
                while (!f.isEmpty()) {
                    s.push(f.pop());
                }
            }

            return s.isEmpty() ? -1 : s.pop();
        }
    }
}
