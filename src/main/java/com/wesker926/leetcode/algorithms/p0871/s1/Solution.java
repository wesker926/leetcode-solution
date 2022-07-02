package com.wesker926.leetcode.algorithms.p0871.s1;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/7/2
 * @description 贪心
 * 根据当前能走到的最远距离，来挑选路途上最好的加油站
 * 简单说就是，没必要立刻加油，没油了才加
 * 和 LCP-p030 思路相同
 */
public class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int ans = 0;
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i = 0; startFuel < target; ans++) {
            for (; i < stations.length && stations[i][0] <= startFuel; i++) {
                queue.offer(stations[i][1]);
            }
            if (queue.isEmpty()) {
                return -1;
            }
            startFuel += queue.poll();
        }
        return ans;
    }
}
