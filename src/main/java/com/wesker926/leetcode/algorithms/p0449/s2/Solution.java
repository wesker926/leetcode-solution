package com.wesker926.leetcode.algorithms.p0449.s2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author wesker.gh
 * @date 2022/5/11
 * @description BST - 先序递归
 */
public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(sb, root);
        return sb.length() == 0 ? "" : sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        Queue<Integer> queue = Arrays.stream(data.split(","))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
        return construct(queue, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private void preOrder(StringBuilder sb, TreeNode node) {
        if (node != null) {
            sb.append(node.val).append(',');
            preOrder(sb, node.left);
            preOrder(sb, node.right);
        }
    }

    private TreeNode construct(Queue<Integer> queue, int max, int min) {
        if (queue.isEmpty() || queue.peek() > max || queue.peek() < min) {
            return null;
        }
        TreeNode node = new TreeNode(queue.poll());
        node.left = construct(queue, node.val, min);
        node.right = construct(queue, max, node.val);
        return node;
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
