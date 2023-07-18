package com.wesker926.leetcode.algorithms.p1851.s1;

/**
 * @author wesker.gh
 * @date 2023/7/18
 * @description 线段树
 * 最优解是离线查询+优先级队列 https://leetcode.cn/problems/minimum-interval-to-include-each-query/solutions/755628/bao-han-mei-ge-cha-xun-de-zui-xiao-qu-ji-e21j/
 */
public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] ans = new int[queries.length];
        Node root = new Node(1, 10000000, Integer.MAX_VALUE);
        for (int[] in : intervals) add(root, in[0], in[1], in[1] - in[0] + 1);
        for (int i = 0; i < queries.length; i++) ans[i] = query(root, queries[i]);
        return ans;
    }

    int query(Node root, int num) {
        int ans = root.v;
        for (Node node = root; node != null; node = num <= node.m ? node.left : node.right) {
            ans = Math.min(ans, node.v);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    void add(Node node, int l, int r, int v) {
        if (l > node.r || r < node.l) return;
        if (node.l >= l && node.r <= r) {
            node.v = Math.min(node.v, v);
            return;
        }
        if (l <= node.m) {
            if (node.left == null) node.left = new Node(node.l, node.m, Integer.MAX_VALUE);
            add(node.left, l, r, v);
        }
        if (r > node.m) {
            if (node.right == null) node.right = new Node(node.m + 1, node.r, Integer.MAX_VALUE);
            add(node.right, l, r, v);
        }
    }

    private static class Node {
        int l, r, m, v;
        Node left;
        Node right;

        Node(int l, int r, int v) {
            this.l = l;
            this.r = r;
            this.m = l + (r - l) / 2;
            this.v = v;
        }
    }
}
