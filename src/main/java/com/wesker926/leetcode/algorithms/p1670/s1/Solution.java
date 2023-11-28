package com.wesker926.leetcode.algorithms.p1670.s1;

/**
 * @author wesker.gh
 * @date 2023/11/28
 * @description 链表
 * 链表可能是自讨苦吃，两个双端队列更好些
 */
public class Solution {

    int len;

    Node head, mid;

    /**
     * Your FrontMiddleBackQueue object will be instantiated and called as such:
     * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
     * obj.pushFront(val);
     * obj.pushMiddle(val);
     * obj.pushBack(val);
     * int param_4 = obj.popFront();
     * int param_5 = obj.popMiddle();
     * int param_6 = obj.popBack();
     */
    public Solution() {
        this.len = 0;
        this.head = new Node(-1);
        head.nxt = head;
        head.pre = head;
        mid = head;
    }

    public void pushFront(int val) {
        insert(head, new Node(val));
        if ((++len) == 1 || (len & 1) == 0) mid = mid.pre;
    }

    public void pushMiddle(int val) {
        if (((++len) & 1) == 1) {
            insert(mid, new Node(val));
            mid = mid.nxt;
        } else {
            insert(mid.pre, new Node(val));
            mid = mid.pre;
        }
    }

    public void pushBack(int val) {
        insert(head.pre, new Node(val));
        if (((++len) & 1) == 1) mid = mid.nxt;
    }

    public int popFront() {
        if (len == 0) return -1;
        if ((--len) == 0 || (len & 1) == 1) mid = mid.nxt;
        return delete(head.nxt);
    }

    public int popMiddle() {
        if (len == 0) return -1;
        if (((--len) & 1) == 1) {
            mid = mid.nxt;
            return delete(mid.pre);
        } else {
            mid = mid.pre;
            return delete(mid.nxt);
        }
    }

    public int popBack() {
        if (len == 0) return -1;
        if (((--len) & 1) == 0) mid = mid.pre;
        return delete(head.pre);
    }

    private void insert(Node p, Node n) {
        n.pre = p;
        n.nxt = p.nxt;
        p.nxt.pre = n;
        p.nxt = n;
    }

    private int delete(Node n) {
        int val = n.val;
        n.pre.nxt = n.nxt;
        n.nxt.pre = n.pre;
        return val;
    }

    private static class Node {

        int val;

        Node pre, nxt;

        Node(int val) {
            this.val = val;
        }
    }
}
