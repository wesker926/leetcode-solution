package com.wesker926.leetcode.algorithms.p0622.s1;

/**
 * @author wesker.gh
 * @date 2022/8/2
 * @description 数组模拟
 * 可以将数组长度设置为k+1从而略去count计数
 * 也可以使用链表模拟
 */
public class Solution {

    private final int size;

    private int count;

    private int head;

    private int tail;

    private final int[] queue;

    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
    public Solution(int k) {
        queue = new int[k];
        head = 0;
        tail = 0;
        size = k;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (count == size) {
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % size;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (count == 0) {
            return false;
        }
        head = (head + 1) % size;
        count--;
        return true;
    }

    public int Front() {
        return count == 0 ? -1 : queue[head];
    }

    public int Rear() {
        return count == 0 ? -1 : queue[(tail - 1 + size) % size];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}
