package com.wesker926.leetcode.algorithms.p0707.s1;

/**
 * @author wesker.gh
 * @date 2022/9/23
 * @description 双向链表
 */
public class Solution {

    private int count;

    private final Node head;

    private final Node tail;

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    public Solution() {
        head = new Node(-1);
        tail = new Node(-1, head, null);
        head.nxt = tail;
        count = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        Node cur = head.nxt;
        for (int i = 0; i < index; i++) {
            cur = cur.nxt;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        add(val, head);
    }

    public void addAtTail(int val) {
        add(val, tail.pre);
    }

    public void addAtIndex(int index, int val) {
        if (index > count) {
            return;
        }
        index = Math.max(index, 0);
        Node pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.nxt;
        }
        add(val, pre);
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= count) {
            return;
        }
        Node cur = head.nxt;
        for (int i = 0; i < index; i++) {
            cur = cur.nxt;
        }
        cur.pre.nxt = cur.nxt;
        cur.nxt.pre = cur.pre;
        count--;
    }

    private void add(int val, Node pre) {
        Node insert = new Node(val, pre, pre.nxt);
        insert.nxt.pre = insert;
        insert.pre.nxt = insert;
        count++;
    }

    private static class Node {

        int val;

        Node pre, nxt;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node pre, Node nxt) {
            this.val = val;
            this.pre = pre;
            this.nxt = nxt;
        }
    }
}
