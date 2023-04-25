package com.wesker926.leetcode.algorithms.p2418.s2;

/**
 * @author wesker.gh
 * @date 2023/4/25
 * @description 排序
 * 自写快排
 */
public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        quickSort(0, heights.length - 1, heights, names);
        return names;
    }

    private void quickSort(int l, int r, int[] a, String[] b) {
        if (l >= r) {
            return;
        }
        int m = l;
        for (int j = l; j <= r; j++) {
            if (a[j] >= a[r]) {
                swap(m++, j, a, b);
            }
        }
        quickSort(l, m - 2, a, b);
        quickSort(m, r, a, b);
    }

    private void swap(int i, int j, int[] a, String[] b) {
        int t1 = a[i];
        a[i] = a[j];
        a[j] = t1;
        String t2 = b[i];
        b[i] = b[j];
        b[j] = t2;
    }
}
