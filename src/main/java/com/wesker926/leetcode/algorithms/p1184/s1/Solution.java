package com.wesker926.leetcode.algorithms.p1184.s1;

/**
 * @author wesker.gh
 * @date 2022/7/24
 * @description 一次遍历
 */
public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum = 0, part = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
            if (i >= start && i < destination) {
                part += distance[i];
            }
        }
        return Math.min(part, sum - part);
    }
}
