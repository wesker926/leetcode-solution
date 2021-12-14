package com.wesker926.leetcode.algorithms.p0630.s1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2021/12/14
 * @description 贪心 + 优先级队列
 */
public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));

        int total = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int[] course : courses) {
            if (course[0] + total <= course[1]) {
                total += course[0];
                queue.offer(course[0]);
            } else if (!queue.isEmpty() && queue.peek() > course[0]) {
                total += course[0] - queue.poll();
                queue.offer(course[0]);
            }
        }
        return queue.size();
    }
}
