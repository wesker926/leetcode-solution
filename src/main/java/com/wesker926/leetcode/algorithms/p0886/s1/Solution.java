package com.wesker926.leetcode.algorithms.p0886.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/10/16
 * @description DFS
 * 分两组染色
 */
public class Solution {
    @SuppressWarnings("all")
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(i, 1, color, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int cur, int target, int[] color, List<Integer>[] graph) {
        color[cur] = target;
        for (int next : graph[cur]) {
            if (color[next] != 0 && color[next] == color[cur]) {
                return false;
            }
            if (color[next] == 0 && !dfs(next, 3 - target, color, graph)) {
                return false;
            }
        }
        return true;
    }
}
