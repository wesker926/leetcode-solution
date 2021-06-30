package com.wesker926.leetcode.lcof.s0001to0050.s0037;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * @author wesker
 * @date 2021/6/30
 * @description 剑指 Offer 37. 序列化二叉树
 */
public class Solution {

    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        int notNull = root == null ? 0 : 1;

        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) {
                if (notNull > 0) {
                    sj.add("null");
                }
                continue;
            } else {
                notNull--;
            }

            sj.add(String.valueOf(cur.val));
            queue.offer(cur.left);
            queue.offer(cur.right);
            notNull += (cur.left == null ? 0 : 1) + (cur.right == null ? 0 : 1);
        }
        return sj.toString();
    }

    /**
     * Decodes your encoded data to tree.
     */
    public TreeNode deserialize(String data) {
        if (data.length() <= 2) {
            return null;
        }

        String[] sp = data.substring(1, data.length() - 1).split(",");
        if (sp.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(sp[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        int idx = 1;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            cur.left = (idx >= sp.length || "null".equals(sp[idx]) ? null : new TreeNode(Integer.parseInt(sp[idx])));
            cur.right = (idx + 1 >= sp.length || "null".equals(sp[idx + 1]) ? null : new TreeNode(Integer.parseInt(sp[idx + 1])));
            idx += 2;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return root;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
}
