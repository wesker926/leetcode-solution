package com.wesker926.leetcode.algorithms.p0155.s1;

import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/6/1
 * @description 双栈模拟
 */
public class Solution {

    LinkedList<Integer> val = new LinkedList<>();

    LinkedList<Integer> min = new LinkedList<>();

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public Solution() {
    }

    public void push(int val) {
        this.val.push(val);
        if (min.isEmpty() || val <= min.peekFirst()) {
            min.push(val);
        }
    }

    public void pop() {
        if (val.isEmpty()) {
            return;
        }
        int v = val.pop();
        if (!min.isEmpty() && min.peekFirst() == v) {
            min.pop();
        }
    }

    public int top() {
        if (val.isEmpty()) {
            return -1;
        }
        return val.peekFirst();
    }

    public int getMin() {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peekFirst();
    }
}
