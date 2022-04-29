package com.wesker926.leetcode.algorithms.p0427.s1;

/**
 * @author wesker.gh
 * @date 2022/4/29
 * @description 递归
 */
public class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return dfs(grid, 0, 0, n);
    }

    private Node dfs(int[][] grid, int l, int t, int c) {
        if (c == 1) {
            return new Node(grid[l][t] == 1, true);
        }

        c >>= 1;
        Node[] children = new Node[4];
        boolean isLeaf = true;
        int valSum = 0;
        for (int i = 0, idx = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                children[idx] = dfs(grid, l + i * c, t + j * c, c);
                isLeaf &= children[idx].isLeaf;
                valSum += children[idx++].val ? 1 : 0;
            }
        }

        if (isLeaf && (valSum == 0 || valSum == 4)) {
            return new Node(valSum == 4, true);
        } else {
            return new Node(false, false, children[0], children[1], children[2], children[3]);
        }
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
