package com.wesker926.leetcode.algorithms.p0692.s3;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2021/12/18
 * @description 快速选择
 */
public class Solution {
    private static int entryCompare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return !e1.getValue().equals(e2.getValue()) ? e2.getValue() - e1.getValue() : e1.getKey().compareTo(e2.getKey());
    }

    private static void swap(Map.Entry<String, Integer>[] arr, int i, int j) {
        Map.Entry<String, Integer> t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int i = 0;
        Map.Entry<String, Integer>[] arr = new Map.Entry[map.size()];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arr[i++] = entry;
        }

        for (int l = 0, r = arr.length - 1, m; l <= r; ) {
            m = partition(arr, l, r);
            if (m == k - 1) {
                List<String> result = new LinkedList<>();
                Arrays.sort(arr, 0, k, Solution::entryCompare);
                for (int j = 0; j < k; j++) {
                    result.add(arr[j].getKey());
                }
                return result;
            } else if (m < k - 1) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return null;
    }

    private int partition(Map.Entry<String, Integer>[] arr, int l, int r) {
        int idx = l;
        for (int i = l; i < r; i++) {
            if (entryCompare(arr[i], arr[r]) <= 0) {
                swap(arr, i, idx++);
            }
        }
        swap(arr, idx, r);
        return idx;
    }
}
