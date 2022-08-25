package com.wesker926.leetcode.algorithms.p0658.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/8/25
 * @description 二分 + 双指针
 */
public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int idx = Arrays.binarySearch(arr, x);
        int i = idx >= 0 ? idx - 1 : -idx - 2, j = idx >= 0 ? idx : -idx - 1;
        while (j - i <= k) {
            if (i >= 0 && (j >= arr.length || x - arr[i] <= arr[j] - x)) {
                i--;
            } else {
                j++;
            }
        }
        List<Integer> ans = new ArrayList<>(k);
        for (int l = i + 1; l < j; l++) {
            ans.add(arr[l]);
        }
        return ans;
    }
}
