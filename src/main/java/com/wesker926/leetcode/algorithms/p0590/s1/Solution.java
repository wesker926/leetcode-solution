package com.wesker926.leetcode.algorithms.p0590.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/3/12
 * @description DFS 递归
 */
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (node.children != null) {
            for (Node child : node.children) {
                dfs(child, result);
            }
        }
        result.add(node.val);
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
