package com.wesker926.leetcode.algorithms.p1305.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description BST中序遍历迭代法 + 合并两个有序链表
 */
public class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new LinkedList<>();
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        while (!stack1.isEmpty() || root1 != null || !stack2.isEmpty() || root2 != null) {
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }
            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peekFirst().val <= stack2.peekFirst().val)) {
                root1 = stack1.poll();
                ans.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = stack2.poll();
                ans.add(root2.val);
                root2 = root2.right;
            }
        }
        return ans;
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
