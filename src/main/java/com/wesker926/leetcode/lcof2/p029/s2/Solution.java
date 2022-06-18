package com.wesker926.leetcode.lcof2.p029.s2;

/**
 * @author wesker.gh
 * @date 2022/6/18
 * @description 最多一趟遍历
 * 在s1的基础上，遇到可插入的位置直接break
 * 最多只会走一趟
 */
public class Solution {
    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal), cur = head;
        if (head == null) {
            insert.next = insert;
            return insert;
        }
        for (; cur.next.val >= cur.val && cur.next != head; cur = cur.next) {
            if (cur.val <= insertVal && cur.next.val >= insertVal) {
                break;
            }
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
