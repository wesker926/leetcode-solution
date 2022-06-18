package com.wesker926.leetcode.lcof2.p029.s1;

/**
 * @author wesker.gh
 * @date 2022/6/18
 * @description 最多两趟遍历
 * 找到链表的尾端后，如果尾端大于insert，继续找不小于insert的节点的前一个节点
 * 最多会走两趟
 */
public class Solution {
    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal), cur = head;
        if (head == null) {
            insert.next = insert;
            return insert;
        }
        for (; cur.next.val >= cur.val && cur.next != head; cur = cur.next) {
        }
        if (cur.val > insertVal) {
            for (; cur.next.val < insertVal; cur = cur.next) {
            }
        }
        insert.next = cur.next;
        cur.next = insert;
        return head;
    }

    private static class Node {

        public int val;

        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
