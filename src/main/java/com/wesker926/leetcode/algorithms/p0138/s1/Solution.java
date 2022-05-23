package com.wesker926.leetcode.algorithms.p0138.s1;

/**
 * @author wesker.gh
 * @date 2022/5/23
 * @description 多次遍历
 * 先复制并插到原节点后，再写入random，再拆开。
 * 注意：上面三步不可换序不可合并。
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node cur = head; cur != null; ) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        for (Node cur = head; cur != null; cur = cur.next.next) {
            cur.next.random = cur.random == null ? null : cur.random.next;
        }
        Node newHead = head.next;
        for (Node cur = head, temp; cur != null; cur = cur.next) {
            temp = cur.next.next;
            cur.next.next = temp == null ? null : temp.next;
            cur.next = temp;
        }
        return newHead;
    }

    private static class Node {

        int val;

        Node next;

        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
