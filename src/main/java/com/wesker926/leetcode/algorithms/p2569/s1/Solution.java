package com.wesker926.leetcode.algorithms.p2569.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/7/26
 * @description 线段树
 * 不用懒标记会超时
 */
public class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        Node root = new Node(0, nums1.length - 1);
        for (int i = 0, j = 0; j <= nums1.length; j++) {
            if (j == nums1.length || nums1[j] != nums1[i]) {
                if (nums1[i] == 1) flip(root, i, j - 1);
                i = j;
            }
        }
        long sum = 0;
        for (int num : nums2) sum += num;
        List<Long> collect = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) flip(root, query[1], query[2]);
            else if (query[0] == 2) sum += ((long) root.sum) * query[1];
            else collect.add(sum);
        }
        long[] ans = new long[collect.size()];
        for (int i = 0; i < collect.size(); i++) ans[i] = collect.get(i);
        return ans;
    }

    private void flip(Node node, int l, int r) {
        if (node.l > r || node.r < l) return;
        if (node.l >= l && node.r <= r) {
            node.sum = node.r - node.l + 1 - node.sum;
            if (node.left != null) node.mark = !node.mark;
            return;
        }
        down(node);
        if (node.left == null) {
            node.left = new Node(node.l, node.m);
            node.left.sum = node.sum == 0 ? 0 : node.m - node.l + 1;
            node.right = new Node(node.m + 1, node.r);
            node.right.sum = node.sum == 0 ? 0 : node.r - node.m;
        }
        flip(node.left, l, r);
        flip(node.right, l, r);
        node.sum = node.left.sum + node.right.sum;
    }

    private void down(Node node) {
        if (!node.mark) return;
        node.mark = false;
        node.left.sum = node.left.r - node.left.l + 1 - node.left.sum;
        node.right.sum = node.right.r - node.right.l + 1 - node.right.sum;
        if (node.left.left != null) node.left.mark = !node.left.mark;
        if (node.right.right != null) node.right.mark = !node.right.mark;
    }

    private static class Node {
        int sum, l, r, m;
        boolean mark;
        Node left, right;

        Node(int l, int r) {
            this.l = l;
            this.r = r;
            m = l + (r - l) / 2;
            mark = false;
        }
    }
}
