package com.wesker926.leetcode.algorithms.p1801.s1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2023/1/2
 * @description 双堆模拟
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    @SuppressWarnings("all")
    public int getNumberOfBacklogOrders(int[][] orders) {
        long ans = 0;
        PriorityQueue<int[]>[] queue = new PriorityQueue[]{
                new PriorityQueue<int[]>((a, b) -> b[0] - a[0]),
                new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]))
        };
        for (int[] order : orders) {
            int factor = order[2] * 2 - 1, amount = order[1];
            PriorityQueue<int[]> match = queue[1 - order[2]];
            while (amount > 0 && !match.isEmpty() && (match.peek()[0] - order[0]) * factor >= 0) {
                int sub = amount - match.peek()[1];
                if (sub < 0) {
                    match.peek()[1] -= amount;
                } else {
                    match.poll();
                }
                amount = Math.max(sub, 0);
            }
            if (amount > 0) {
                queue[order[2]].offer(new int[]{order[0], amount, order[2]});
            }
            ans = (ans - order[1] + (long) amount * 2 + MOD) % MOD;
        }
        return (int) ans;
    }
}
