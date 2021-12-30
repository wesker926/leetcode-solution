package com.wesker926.leetcode.algorithms.p0846.s2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2021/12/30
 * @description 聚合 + 排序 + 滑动窗口
 */
public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int i = 0;
        int[][] arr = new int[map.size()][2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[i][0] = entry.getKey();
            arr[i++][1] = entry.getValue();
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int l = 0, r = groupSize - 1;
        while (r < arr.length) {
            arr[l][1]--;
            for (int j = l + 1; j <= r; j++) {
                if (arr[j][0] != arr[j - 1][0] + 1 || arr[j][1] == 0) {
                    return false;
                }
                arr[j][1]--;
            }
            for (; l < arr.length && arr[l][1] == 0; l++) {
            }
            r = l + groupSize - 1;
        }
        return l == arr.length;
    }
}
