package com.wesker926.leetcode.lcof.p007.s2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/3/29
 * @description 递归构造 + 哈希表加速
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, inMap, 0, 0, preorder.length);
    }

    private TreeNode build(int[] pre, Map<Integer, Integer> in, int s1, int s2, int len) {
        if (len <= 0) {
            return null;
        }

        TreeNode cur = new TreeNode(pre[s1]);
        int idx = in.getOrDefault(pre[s1], -1);
        if (idx >= 0) {
            cur.left = build(pre, in, s1 + 1, s2, idx - s2);
            cur.right = build(pre, in, s1 + idx - s2 + 1, idx + 1, len - idx + s2 - 1);
        }
        return cur;
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
