package com.wesker926.leetcode.algorithms.p1792.s1;

import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2023/2/19
 * @description 优先队列
 * 优先给通过率增加最多的班级安排当前的学生，重复直到学生分配完毕
 * 注意乘法的整型溢出
 */
public class Solution {
    @SuppressWarnings("all")
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> incr(o2) - incr(o1) > 0 ? 1 : -1);
        for (int[] clazz : classes) {
            queue.offer(clazz);
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] cur = queue.poll();
            cur[0] += 1;
            cur[1] += 1;
            queue.offer(cur);
        }
        double ans = 0;
        for (int[] clazz : queue) {
            ans += (double) clazz[0] / clazz[1];
        }
        return ans / classes.length;
    }

    private double incr(int[] o) {
        return (o[1] - o[0]) / ((double) o[1] * (o[1] + 1));
    }
}
