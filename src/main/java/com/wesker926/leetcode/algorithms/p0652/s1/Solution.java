package com.wesker926.leetcode.algorithms.p0652.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/9/5
 * @description DFS + 三元组
 * 相较于直接序列化子数，三元组使用序号替代了子树字符串，同时减少了时间空间复杂度
 */
public class Solution {

    int idx;

    private Set<TreeNode> repeat;

    private Map<String, Pair> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        idx = 0;
        map = new HashMap<>();
        repeat = new HashSet<>();
        dfs(root);
        return new ArrayList<>(repeat);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        String key = Arrays.toString(new int[]{node.val, dfs(node.left), dfs(node.right)});
        if (map.containsKey(key)) {
            Pair cur = map.get(key);
            repeat.add(cur.node);
            return cur.seq;
        } else {
            map.put(key, new Pair(++idx, node));
            return idx;
        }
    }

    private static class Pair {

        int seq;

        TreeNode node;

        Pair(int seq, TreeNode node) {
            this.seq = seq;
            this.node = node;
        }
    }

    private static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
