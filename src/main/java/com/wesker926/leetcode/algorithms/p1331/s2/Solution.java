package com.wesker926.leetcode.algorithms.p1331.s2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/7/28
 * @description 排序 + 哈希
 * 哈希反而快
 */
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] copy = Arrays.copyOf(arr, n);
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 1; i < n; i++) {
            if (i == 0 || copy[i] != copy[i - 1]) {
                map.put(copy[i], j++);
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
