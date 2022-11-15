package com.wesker926.leetcode.algorithms.p1710.s1;

/**
 * @author wesker.gh
 * @date 2022/11/15
 * @description 计数排序
 * 可以用普通排序
 * 也可以用快速选择算法
 */
public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] boxes = new int[1001];
        for (int[] box : boxTypes) {
            boxes[box[1]] += box[0];
        }
        int ans = 0;
        for (int i = 1000; i >= 0 && truckSize > 0; i--) {
            int count = Math.min(truckSize, boxes[i]);
            ans += count * i;
            truckSize -= count;
        }
        return ans;
    }
}
