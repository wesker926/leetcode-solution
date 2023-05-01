package com.wesker926.leetcode.algorithms.p1376.s1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2023/5/1
 * @description 邻接表 + BFS
 * 使用自底向上的DFS（迭代写法）可以达到O(1)空间
 */
public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] hd = new int[n], nt = new int[n], eg = new int[n];
        Arrays.fill(hd, -1);
        for (int i = 0, idx = 0; i < n; i++) {
            if (manager[i] == -1) continue;
            eg[idx] = i;
            nt[idx] = hd[manager[i]];
            hd[manager[i]] = idx++;
        }
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{headID, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            ans = Math.max(ans, cur[1]);
            for (int i = hd[cur[0]], time = cur[1] + informTime[cur[0]]; i >= 0; i = nt[i]) {
                queue.offer(new int[]{eg[i], time});
            }
        }
        return ans;
    }
}
