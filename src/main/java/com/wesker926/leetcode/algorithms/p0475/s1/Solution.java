package com.wesker926.leetcode.algorithms.p0475.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2021/12/20
 * @description 双数组遍历
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int max = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            for (; j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1]); j++) {
            }
            max = Math.max(max, Math.abs(houses[i] - heaters[j]));
        }
        return max;
    }
}
