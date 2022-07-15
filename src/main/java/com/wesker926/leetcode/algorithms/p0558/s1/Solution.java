package com.wesker926.leetcode.algorithms.p0558.s1;

/**
 * @author wesker.gh
 * @date 2022/7/15
 * @description DFS
 * 如果子树相同需要合并
 */
public class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree2.isLeaf) {
            Node temp = quadTree1;
            quadTree1 = quadTree2;
            quadTree2 = temp;
        }
        if (quadTree1.isLeaf && (quadTree2.isLeaf || quadTree1.val)) {
            return new Node(quadTree1.val || quadTree2.val, true, null, null, null, null);
        }
        Node tl = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topLeft, quadTree2.topLeft);
        Node tr = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topRight, quadTree2.topRight);
        Node bl = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node br = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomRight, quadTree2.bottomRight);
        return tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf &&
                tl.val == tr.val && tl.val == bl.val && tl.val == br.val ?
                new Node(tl.val, true, null, null, null, null) :
                new Node(false, false, tl, tr, bl, br);
    }

    private static class Node {

        public boolean val;

        public boolean isLeaf;

        public Node topLeft;

        public Node topRight;

        public Node bottomLeft;

        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}
