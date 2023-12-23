package com.wesker926.leetcode.algorithms.p1962.s1;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2023/12/23
 * @description 优先级队列
 */
public class Solution {
    @SuppressWarnings("all")
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) {
            queue.offer(pile);
            sum += pile;
        }
        for (int i = 0; i < k; i++) {
            int num = queue.poll(), sub = num >> 1;
            queue.offer(num - sub);
            sum -= sub;
        }
        return sum;
    }
}
