package com.wesker926.leetcode.algorithms.p0641.s1;

/**
 * @author wesker.gh
 * @date 2022/8/15
 * @description 循环数组
 * 注意起始位置
 */
public class Solution {

    private int head;

    private int tail;

    private int count;

    private final int[] queue;

    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */
    public Solution(int k) {
        queue = new int[k];
        head = 0;
        tail = k == 1 ? 0 : 1;
        count = 0;
    }

    public boolean insertFront(int value) {
        return insert(value, true);
    }

    public boolean insertLast(int value) {
        return insert(value, false);
    }

    private boolean insert(int val, boolean insertHead) {
        if (queue.length == count) {
            return false;
        }
        if (insertHead) {
            queue[head] = val;
            head = (head + queue.length - 1) % queue.length;
        } else {
            queue[tail] = val;
            tail = (tail + 1) % queue.length;
        }
        count++;
        return true;
    }

    public boolean deleteFront() {
        return delete(true);
    }

    public boolean deleteLast() {
        return delete(false);
    }

    private boolean delete(boolean deleteHead) {
        if (count == 0) {
            return false;
        }
        if (deleteHead) {
            head = (head + 1) % queue.length;
        } else {
            tail = (tail + queue.length - 1) % queue.length;
        }
        count--;
        return true;
    }

    public int getFront() {
        return count == 0 ? -1 : queue[(head + 1) % queue.length];
    }

    public int getRear() {
        return count == 0 ? -1 : queue[(tail + queue.length - 1) % queue.length];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == queue.length;
    }
}
