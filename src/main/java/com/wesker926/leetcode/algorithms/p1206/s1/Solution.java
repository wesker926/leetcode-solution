package com.wesker926.leetcode.algorithms.p1206.s1;

/**
 * @author wesker.gh
 * @date 2022/7/26
 * @description 构造跳表
 */
public class Solution {

    private int level;

    private int count;

    private Node head;

    /**
     * Your Skiplist object will be instantiated and called as such:
     * Skiplist obj = new Skiplist();
     * boolean param_1 = obj.search(target);
     * obj.add(num);
     * boolean param_3 = obj.erase(num);
     */
    public Solution() {
        this.level = 0;
        this.count = 0;
        this.head = new Node(-1, null, new Node(-1, null, null, null), null);
        head.nxt.pre = head;
    }

    public boolean search(int target) {
        return search(target, head);
    }

    public void add(int num) {
        boolean exist = search(num);
        if (exist) {
            addCount(num, head);
        } else {
            count++;
            if (count > Math.pow(2, level)) {
                head = new Node(-1, null, new Node(-1, null, null, null), head);
                head.nxt.pre = head;
                level++;
            }
            add(num, head, (int) (Math.random() * (Math.pow(2, level))), 1);
        }
    }

    public boolean erase(int num) {
        if (!search(num)) {
            return false;
        }
        if (erase(num, head)) {
            count--;
            if (level != 0 && count <= Math.pow(2, level - 1)) {
                head = head.down;
                level--;
            }
        }
        return true;
    }

    private boolean search(int tar, Node node) {
        if (node == null) {
            return false;
        }
        node = layerSearch(tar, node);
        return node.val == tar || search(tar, node.down);
    }

    private void addCount(int num, Node node) {
        if (node == null) {
            return;
        }
        node = layerSearch(num, node);
        addCount(num, node.down);
        if (node.val == num) {
            node.count++;
        }
    }

    private Node add(int num, Node node, int random, int range) {
        if (node == null) {
            return null;
        }
        node = layerSearch(num, node);
        Node down = add(num, node.down, random, range << 1);
        if (random < range) {
            node.nxt = new Node(num, node, node.nxt, down);
            node.nxt.nxt.pre = node.nxt;
            return node.nxt;
        }
        return null;
    }

    private boolean erase(int num, Node node) {
        if (node == null) {
            return false;
        }
        node = layerSearch(num, node);
        boolean isRemove = erase(num, node.down);
        if (node.val == num) {
            if (node.count > 1) {
                node.count--;
                return false;
            } else {
                node.pre.nxt = node.nxt;
                node.nxt.pre = node.pre;
                return true;
            }
        }
        return isRemove;
    }

    private Node layerSearch(int num, Node node) {
        while (node.nxt.val >= 0 && node.nxt.val <= num) {
            node = node.nxt;
        }
        return node;
    }

    private static class Node {

        int val;

        int count;

        Node pre;

        Node nxt;

        Node down;

        Node(int val, Node pre, Node nxt, Node down) {
            this.val = val;
            this.count = 1;
            this.pre = pre;
            this.nxt = nxt;
            this.down = down;
        }
    }
}
