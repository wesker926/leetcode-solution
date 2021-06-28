package com.wesker926.leetcode.algorithms.s0801to0850.s0815;

import java.util.*;

/**
 * @author wesker
 * @date 2021/6/28
 * @description 815. 公交路线
 */
public class Solution {
    /**
     * 没有经过优化的思路
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                map.computeIfAbsent(j, k -> new LinkedList<>()).add(i);
            }
        }
        List<Integer> buses = map.getOrDefault(source, Collections.emptyList());
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        int step = 1, count = buses.size(), bus;
        int[] route;
        for (int i : buses) {
            queue.offer(i);
            visit.add(i);
        }
        while (!queue.isEmpty()) {
            bus = queue.poll();
            route = routes[bus];
            for (int r : route) {
                if (r == target) {
                    return step;
                }
                for (int b : map.get(r)) {
                    if (!visit.contains(b)) {
                        queue.offer(b);
                        visit.add(b);
                    }
                }
            }
            count--;
            if (count == 0) {
                step++;
                count = queue.size();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] r = {{1, 2, 7}, {3, 6, 7}};
        System.out.println(new Solution().numBusesToDestination(r, 1, 6));
    }
}
