package com.wesker926.leetcode.algorithms.p0146.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/5/26
 * @description 哈希表 + 链表
 */
public class Solution {

    private final int maxSize;

    private final Node head = new Node(-1, -1), tail = new Node(-1, -1);

    private final Map<Integer, Node> map = new HashMap<>();

    public Solution(int capacity) {
        this.maxSize = capacity;
        this.head.nxt = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        Node cur = map.getOrDefault(key, null);
        return cur != null ? addFirst(remove(cur)).val : -1;
    }

    public void put(int key, int value) {
        Node cur = map.getOrDefault(key, null);
        if (cur != null) {
            addFirst(remove(cur)).val = value;
            return;
        }
        if (map.size() == maxSize) {
            map.remove(remove(tail.pre).key);
        }
        map.put(key, addFirst(new Node(key, value)));
    }

    private Node remove(Node node) {
        node.pre.nxt = node.nxt;
        node.nxt.pre = node.pre;
        node.pre = null;
        node.nxt = null;
        return node;
    }

    private Node addFirst(Node node) {
        node.nxt = head.nxt;
        node.pre = head;
        node.nxt.pre = node;
        head.nxt = node;
        return node;
    }

    private static class Node {

        private int key;

        private int val;

        private Node pre;

        private Node nxt;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
