package com.wesker926.leetcode.algorithms.p0460.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/9/25
 * @description 双哈希表
 * https://leetcode.cn/problems/lfu-cache/solutions/186348/lfuhuan-cun-by-leetcode-solution/?envType=daily-question&envId=2023-09-25
 */
public class Solution {

    private int minFreq;

    private final int capacity;

    private final Map<Integer, Node> keyMap;

    private final Map<Integer, List> freqMap;

    public Solution(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.val;
    }

    private Node getNode(int key) {
        Node node = keyMap.get(key);
        if (node == null) return null;
        remove(node);
        node.freq++;
        addFirst(node);
        return node;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node = getNode(key);
        if (node != null) {
            node.val = value;
            return;
        }
        if (keyMap.size() >= capacity) {
            node = freqMap.get(minFreq).dummy.pre;
            keyMap.remove(node.key);
            remove(node);
        }
        node = new Node(key, value, 1);
        keyMap.put(key, node);
        addFirst(node);
        minFreq = 1;
    }

    private void remove(Node node) {
        node.pre.nxt = node.nxt;
        node.nxt.pre = node.pre;
        Node dummy = freqMap.get(node.freq).dummy;
        if (dummy.pre == dummy) {
            freqMap.remove(node.freq);
            if (minFreq == node.freq) minFreq++;
        }
    }

    private void addFirst(Node node) {
        Node dummy = freqMap.computeIfAbsent(node.freq, k -> new List()).dummy;
        node.pre = dummy;
        node.nxt = dummy.nxt;
        dummy.nxt = node;
        node.nxt.pre = node;
    }

    private static class Node {

        int key, val, freq;

        Node pre, nxt;

        Node() {
        }

        Node(int k, int v, int f) {
            key = k;
            val = v;
            freq = f;
        }
    }

    private static class List {

        Node dummy;

        List() {
            dummy = new Node();
            dummy.nxt = dummy;
            dummy.pre = dummy;
        }
    }
}
