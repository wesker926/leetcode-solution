package com.wesker926.leetcode.algorithms.p1499.s1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2023/7/21
 * @description 堆
 * 更优的解法是单调队列
 */
public class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int[] point : points) {
            while (!queue.isEmpty() && point[0] - queue.peek()[0] > k) queue.poll();
            if (!queue.isEmpty()) max = Math.max(max, point[0] + point[1] - queue.peek()[1]);
            queue.offer(new int[]{point[0], point[0] - point[1]});
        }
        return max;
    }
}
