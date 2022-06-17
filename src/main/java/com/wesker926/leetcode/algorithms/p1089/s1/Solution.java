package com.wesker926.leetcode.algorithms.p1089.s1;

/**
 * @author wesker.gh
 * @date 2022/6/17
 * @description 双指针
 */
public class Solution {
    public void duplicateZeros(int[] arr) {
        int ed = 0, n = arr.length, cnt = 0;
        for (; ed < n && cnt < n; ed++) {
            cnt += arr[ed] == 0 ? 2 : 1;
        }
        for (int i = ed - 1, j = n - 1; i >= 0; i--) {
            arr[j--] = arr[i];
            if (arr[i] == 0 && (i != ed - 1 || cnt == n)) {
                arr[j--] = arr[i];
            }
        }
    }
}
