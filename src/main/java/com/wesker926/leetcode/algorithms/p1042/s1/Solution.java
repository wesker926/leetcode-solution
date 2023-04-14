package com.wesker926.leetcode.algorithms.p1042.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/4/15
 * @description 遍历
 * 因为每个节点有四种选择，而最多只有三个相邻的点，因此必存在可选的值。
 */
public class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int m = paths.length, idx = 0;
        int[] head = new int[n], next = new int[m * 2], edge = new int[m * 2];
        Arrays.fill(head, -1);
        for (int[] path : paths) {
            add(head, next, edge, idx++, path[0], path[1]);
            add(head, next, edge, idx++, path[1], path[0]);
        }
        int[] ans = new int[n];
        for (int i = 0, j, mask; i < n; i++) {
            for (j = head[i], mask = 0; j != -1; j = next[j]) {
                mask |= 1 << ans[edge[j]];
            }
            mask = (~mask) & 30;
            ans[i] = Integer.bitCount((mask & (-mask)) - 1);
        }
        return ans;
    }

    private void add(int[] h, int[] n, int[] e, int i, int a, int b) {
        n[i] = h[a - 1];
        h[a - 1] = i;
        e[i] = b - 1;
    }
}
