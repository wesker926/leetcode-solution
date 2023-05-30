package com.wesker926.leetcode.algorithms.p1110.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/5/30
 * @description DFS
 * 也可使用后序遍历，通过返回值处理node的左右子节点
 */
public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        boolean[] del = new boolean[1001];
        for (int i : to_delete) del[i] = true;
        del[0] = true;
        return dfs(new TreeNode(0, root, null), del, new ArrayList<>());
    }

    private List<TreeNode> dfs(TreeNode node, boolean[] del, List<TreeNode> res) {
        TreeNode l = node.left, r = node.right;
        if (l != null) {
            if (del[node.val] && !del[l.val]) res.add(l);
            if (!del[node.val] && del[l.val]) node.left = null;
            dfs(l, del, res);
        }
        if (r != null) {
            if (del[node.val] && !del[r.val]) res.add(r);
            if (!del[node.val] && del[r.val]) node.right = null;
            dfs(r, del, res);
        }
        return res;
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
