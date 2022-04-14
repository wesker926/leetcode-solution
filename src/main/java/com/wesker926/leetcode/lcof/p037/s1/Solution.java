package com.wesker926.leetcode.lcof.p037.s1;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/4/14
 * @description 队列
 */
public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int notNull = 1;
        while (!queue.isEmpty() && notNull > 0) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("null,");
                continue;
            }
            sb.append(cur.val).append(",");
            queue.offer(cur.left);
            queue.offer(cur.right);
            notNull += (cur.left == null ? 0 : 1) + (cur.right == null ? 0 : 1);
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2) {
            return null;
        }
        String[] sp = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(sp[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;
        while (!queue.isEmpty() && idx < sp.length) {
            TreeNode cur = queue.poll();
            if (!Objects.equals(sp[idx], "null")) {
                cur.left = new TreeNode(Integer.parseInt(sp[idx]));
                queue.offer(cur.left);
            }
            if (++idx >= sp.length) {
                break;
            }
            if (!Objects.equals(sp[idx], "null")) {
                cur.right = new TreeNode(Integer.parseInt(sp[idx]));
                queue.offer(cur.right);
            }
            idx++;
        }
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
