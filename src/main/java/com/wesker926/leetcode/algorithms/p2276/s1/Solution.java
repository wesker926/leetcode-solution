package com.wesker926.leetcode.algorithms.p2276.s1;

/**
 * @author wesker.gh
 * @date 2023/12/16
 * @description 动态开点线段树
 */
public class Solution {

    private final Node root;

    public Solution() {
        root = new Node(1, (int) 1e9);
    }

    public void add(int left, int right) {
        root.add(left, right);
    }

    public int count() {
        return root.v;
    }

    private static class Node {

        int l, r, v;

        Node left, right;

        Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        int add(int a, int b) {
            System.out.println(this.l + " " + this.r + " " + this.v);
            if (v == r - l + 1) return 0;
            if (b < l || r < a) return 0;
            if (a <= l && r <= b) {
                int add = r - l + 1 - v;
                v += add;
                return add;
            }
            int m = (r - l) / 2 + l;
            if (left == null) {
                left = new Node(l, m);
                right = new Node(m + 1, r);
            }
            int add = left.add(a, b) + right.add(a, b);
            v += add;
            return add;
        }
    }
}
