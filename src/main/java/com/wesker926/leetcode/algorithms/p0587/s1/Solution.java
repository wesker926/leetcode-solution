package com.wesker926.leetcode.algorithms.p0587.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/4/23
 * @description Andrew算法
 */
public class Solution {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }

        Arrays.sort(trees, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int[] stack = new int[n + 1];
        boolean[] bottomHullUsed = new boolean[n];
        int idx = 0;
        stack[idx++] = 0;

        for (int i = 1; i < n; i++) {
            if (trees[i][0] != trees[n - 1][0] && trees[i][0] == trees[stack[idx - 1]][0]) {
                continue;
            }
            while (idx > 1 && cross(trees[stack[idx - 2]], trees[stack[idx - 1]], trees[i]) < 0) {
                bottomHullUsed[stack[--idx]] = false;
            }
            stack[idx++] = i;
            bottomHullUsed[i] = true;
        }

        int bottomSize = idx;
        for (int i = n - 2; i >= 0; i--) {
            if (bottomHullUsed[i] || (trees[i][0] != trees[0][0] && trees[i][0] == trees[stack[idx - 1]][0])) {
                continue;
            }
            while (idx > bottomSize && cross(trees[stack[idx - 2]], trees[stack[idx - 1]], trees[i]) < 0) {
                idx--;
            }
            stack[idx++] = i;
        }
        int[][] ans = new int[idx - 1][];
        for (int i = 0; i < idx - 1; i++) {
            ans[i] = trees[stack[i]];
        }
        return ans;
    }

    private int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (r[0] - q[0]) * (q[1] - p[1]);
    }
}
