package com.wesker926.leetcode.algorithms.p1382.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/13
 * @description 中序遍历 + 平衡树构造
 * 中序遍历参考p0094
 * 平衡树构造参考p0108
 */
public class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = inorder(root, new ArrayList<>());
        return build(inorder, 0, inorder.size() - 1);
    }

    private List<Integer> inorder(TreeNode node, List<Integer> ans) {
        if (node != null) {
            inorder(node.left, ans);
            ans.add(node.val);
            inorder(node.right, ans);
        }
        return ans;
    }

    private TreeNode build(List<Integer> nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        return new TreeNode(nums.get(m), build(nums, l, m - 1), build(nums, m + 1, r));
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
