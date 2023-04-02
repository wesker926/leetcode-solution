package com.wesker926.leetcode.algorithms.p1039.s1;

/**
 * @author wesker.gh
 * @date 2023/4/2
 * @description 记忆化搜索
 * 点i到j构成的凸多边形，边i-j必然属于某个三角形。枚举此三角形的可能情况，将多边形分成三部分后组合，取最小即为所求
 * 注1：为什么只需要考虑顺序的多边形？因为在转移过程中，那些没考虑的多边形的计算已经包含在三角形枚举的过程中。
 * 注2：为什么只需要考虑一条边：因为无论算那条边，结果是一样的，无需冗余计算。
 * 注3：为什么不分成两部分：因为分成两部分需要考虑环，分成的三部分中，三角形恰是环的连接点，能规避这个问题。
 * 环的问题也可以用「复制一倍，断环成链」来解决，但是也挺麻烦，不如分成三部分。
 */
public class Solution {
    public int minScoreTriangulation(int[] values) {
        int[] memory = new int[values.length * values.length];
        return dfs(memory, values, 0, values.length - 1);
    }

    private int dfs(int[] m, int[] v, int i, int j) {
        int key = i * v.length + j;
        if (i + 1 == j || m[key] != 0) {
            return m[key];
        }
        m[key] = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            m[key] = Math.min(m[key], v[i] * v[j] * v[k] + dfs(m, v, i, k) + dfs(m, v, k, j));
        }
        return m[key];
    }
}
