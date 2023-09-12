package com.wesker926.leetcode.algorithms.p1462.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/9/12
 * @description DFS + 拓扑排序
 */
public class Solution {

    private long[][] relation;

    private int[] head, next, edge;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int m = prerequisites.length, idx = 0;
        head = new int[numCourses];
        next = new int[m];
        edge = new int[m];
        Arrays.fill(head, -1);
        for (int[] pair : prerequisites) {
            next[idx] = head[pair[1]];
            head[pair[1]] = idx;
            edge[idx++] = pair[0];
        }
        relation = new long[numCourses][];
        for (int i = 0; i < numCourses; i++) dfs(i);
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            long[] r = relation[query[1]];
            if (query[0] < 50) res.add(((r[0] >> query[0]) & 1) == 1);
            else res.add(((r[1] >> (query[0] - 50)) & 1) == 1);
        }
        return res;
    }

    private long[] dfs(int i) {
        if (relation[i] != null) return relation[i];
        relation[i] = new long[2];
        for (int j = head[i]; j >= 0; j = next[j]) {
            if (edge[j] < 50) relation[i][0] |= 1L << edge[j];
            else relation[i][1] |= 1L << (edge[j] - 50);
            long[] parent = dfs(edge[j]);
            for (int k = 0; k < 2; k++) relation[i][k] |= parent[k];
        }
        return relation[i];
    }
}
