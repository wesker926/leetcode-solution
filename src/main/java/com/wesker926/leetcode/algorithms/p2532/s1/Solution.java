package com.wesker926.leetcode.algorithms.p2532.s1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2023/7/7
 * @description 优先级队列
 */
public class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        int remain = n, curTime = 0;
        int[] workTime = new int[k];
        Comparator<Integer> c1 = (x, y) -> {
            int timeX = time[x][0] + time[x][2];
            int timeY = time[y][0] + time[y][2];
            return timeX != timeY ? timeY - timeX : y - x;
        };
        Comparator<Integer> c2 = Comparator.comparingInt(x -> workTime[x]);
        PriorityQueue<Integer> lWait = new PriorityQueue<>(c1);
        PriorityQueue<Integer> rWait = new PriorityQueue<>(c1);
        PriorityQueue<Integer> lWork = new PriorityQueue<>(c2);
        PriorityQueue<Integer> rWork = new PriorityQueue<>(c2);
        for (int i = 0; i < k; i++) lWait.offer(i);
        while (remain > 0 || !rWork.isEmpty() || !rWait.isEmpty()) {
            while (!lWork.isEmpty() && workTime[lWork.peek()] <= curTime) lWait.offer(lWork.poll());
            while (!rWork.isEmpty() && workTime[rWork.peek()] <= curTime) rWait.offer(rWork.poll());
            if (!rWait.isEmpty()) {
                int id = rWait.poll();
                curTime += time[id][2];
                workTime[id] = curTime + time[id][3];
                lWork.offer(id);
            } else if (remain > 0 && !lWait.isEmpty()) {
                int id = lWait.poll();
                curTime += time[id][0];
                workTime[id] = curTime + time[id][1];
                rWork.offer(id);
                remain--;
            } else {
                int nextTime = Integer.MAX_VALUE;
                if (!lWork.isEmpty()) nextTime = Math.min(nextTime, workTime[lWork.peek()]);
                if (!rWork.isEmpty()) nextTime = Math.min(nextTime, workTime[rWork.peek()]);
                if (nextTime != Integer.MAX_VALUE) curTime = Math.max(curTime, nextTime);
            }
        }
        return curTime;
    }
}
