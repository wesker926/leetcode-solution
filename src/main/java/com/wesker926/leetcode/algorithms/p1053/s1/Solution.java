package com.wesker926.leetcode.algorithms.p1053.s1;

/**
 * @author wesker.gh
 * @date 2023/4/3
 * @description 贪心
 * 主站-p0031的逆向版本
 */
public class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = binary(arr, i + 1, n - 1, arr[i]);
                j = binary(arr, i + 1, j, arr[j]) + 1;
                swap(arr, i, j);
                break;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private int binary(int[] arr, int l, int r, int t) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}
