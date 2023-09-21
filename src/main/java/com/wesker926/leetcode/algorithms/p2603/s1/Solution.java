package com.wesker926.leetcode.algorithms.p2603.s1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2023/9/21
 * @description 拓扑排序
 * 先连续删除所有没有金币的叶子节点，剩余的叶子结点都是有金币的
 * 然后连续两次删除叶子结点（第一次删的都是有金币的叶子节点，第二次删的都是第一次的父节点且无其他子节点）
 */
public class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length, ans = 0;
        int[] head = new int[n], next = new int[n * 2], edge = new int[n * 2], count = new int[n];
        build(edges, head, next, edge, count);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < count.length; i++)
            if (coins[i] == 0 && count[i] == 1) queue.offer(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count[cur] = 0;
            for (int i = head[cur]; i >= 0; i = next[i])
                if ((--count[edge[i]]) == 1 && coins[edge[i]] == 0) queue.offer(edge[i]);
        }

        queue = new LinkedList<>();
        for (int i = 0; i < coins.length; i++)
            if (coins[i] == 1 && count[i] == 1) queue.offer(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count[cur] = 0;
            for (int i = head[cur]; i >= 0; i = next[i])
                if ((--count[edge[i]]) == 1) count[edge[i]] = 0;
        }

        for (int c : count) if (c > 0) ans++;
        return Math.max((ans - 1) * 2, 0);
    }

    private void build(int[][] edges, int[] head, int[] next, int[] edge, int[] count) {
        int idx = 0;
        Arrays.fill(head, -1);
        for (int[] e : edges) {
            for (int i = 0; i < 2; i++) {
                next[idx] = head[e[i]];
                head[e[i]] = idx;
                edge[idx++] = e[1 - i];
                count[e[i]]++;
            }
        }
    }
}
