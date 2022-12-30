package com.wesker926.leetcode.algorithms.p0855.s1;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author wesker.gh
 * @date 2022/12/30
 * @description 树 + 优先级队列 + 延迟删除
 * 延迟删除需要在优先级队列出队时进行额外判断
 */
@SuppressWarnings("all")
public class Solution {

    private final int n;

    private final TreeSet<Integer> seats;

    private final PriorityQueue<int[]> queue;

    /**
     * Your ExamRoom object will be instantiated and called as such:
     * ExamRoom obj = new ExamRoom(n);
     * int param_1 = obj.seat();
     * obj.leave(p);
     */
    public Solution(int n) {
        this.n = n;
        this.seats = new TreeSet<>();
        this.queue = new PriorityQueue<>((a, b) -> {
            int d1 = (a[1] - a[0]) / 2, d2 = (b[1] - b[0]) / 2;
            return d1 > d2 || (d1 == d2 && a[0] < b[0]) ? -1 : 1;
        });
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int left = seats.first(), last = seats.last(), right = n - 1 - last;
        while (seats.size() >= 2 && !queue.isEmpty()) {
            int[] cur = queue.peek();
            if (!seats.contains(cur[0]) || !seats.contains(cur[1]) || seats.higher(cur[0]) != cur[1]) {
                queue.poll();
                continue;
            }
            int d = (cur[1] - cur[0]) / 2;
            if (d <= left || d < right) {
                break;
            }
            queue.poll();
            queue.offer(new int[]{cur[0], cur[0] + d});
            queue.offer(new int[]{cur[0] + d, cur[1]});
            seats.add(cur[0] + d);
            return cur[0] + d;
        }
        if (left >= right) {
            queue.offer(new int[]{0, left});
            seats.add(0);
            return 0;
        } else {
            queue.offer(new int[]{last, n - 1});
            seats.add(n - 1);
            return n - 1;
        }
    }

    public void leave(int p) {
        if (p != seats.first() && p != seats.last()) {
            queue.offer(new int[]{seats.lower(p), seats.higher(p)});
        }
        seats.remove(p);
    }
}
