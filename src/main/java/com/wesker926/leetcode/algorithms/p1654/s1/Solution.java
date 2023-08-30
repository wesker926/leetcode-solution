package com.wesker926.leetcode.algorithms.p1654.s1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2023/8/30
 * @description BFS
 * 难点在求上界：
 * https://leetcode.cn/problems/minimum-jumps-to-reach-home/solutions/485685/dao-jia-de-zui-shao-tiao-yue-ci-shu-zui-duan-lu-zh/
 */
public class Solution {

    private int lower, upper;

    private boolean[] visited;

    private Queue<int[]> queue;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        lower = upper = 0;
        for (int f : forbidden) upper = Math.max(upper, f);
        upper = Math.max(upper + a, x) + b;
        visited = new boolean[upper * 2 + 1];
        for (int f : forbidden) visited[upper + f] = visited[upper - f] = true;
        queue = new LinkedList<>();
        offer(0, 1, 0);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == x) return cur[2];
            offer(cur[0] + a, 1, cur[2] + 1);
            if (cur[1] == 1) offer(cur[0] - b, -1, cur[2] + 1);
        }
        return -1;
    }

    private void offer(int pos, int dir, int step) {
        if (pos < lower || pos > upper || visited[upper + pos]) return;
        visited[upper + pos * dir] = true;
        queue.offer(new int[]{pos, dir, step});
    }
}
