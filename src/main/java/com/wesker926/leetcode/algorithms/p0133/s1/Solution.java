package com.wesker926.leetcode.algorithms.p0133.s1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/5/21
 * @description DFS + 哈希表
 * 注：生成新节点时，必须先放入表中，再补充邻居信息，否则会无限递归
 */
public class Solution {
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node origin, Map<Node, Node> table) {
        if (origin == null) {
            return null;
        }

        if (table.containsKey(origin)) {
            return table.get(origin);
        }

        Node res = new Node(origin.val, new ArrayList<>());
        table.put(origin, res);
        for (Node neighbor : origin.neighbors) {
            res.neighbors.add(dfs(neighbor, table));
        }
        return res;
    }

    private static class Node {

        public int val;

        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
