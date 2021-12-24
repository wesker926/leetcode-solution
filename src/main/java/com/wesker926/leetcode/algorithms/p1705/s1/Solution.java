package com.wesker926.leetcode.algorithms.p1705.s1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2021/12/24
 * @description 优先级队列
 */
public class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        int[] cur = null;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < apples.length || !queue.isEmpty(); i++) {
            if (i < apples.length && apples[i] != 0) {
                queue.offer(new int[]{i + days[i], apples[i]});
            }

            while (!queue.isEmpty()) {
                cur = queue.peek();
                if (cur[0] <= i || cur[1] == 0) {
                    queue.poll();
                } else {
                    break;
                }
            }

            if (!queue.isEmpty()) {
                ans++;
                cur[1]--;
            }
        }
        return ans;
    }
}
