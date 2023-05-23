package com.wesker926.leetcode.algorithms.p1090.s1;

/**
 * @author wesker.gh
 * @date 2023/5/23
 * @description 排序 + 贪心
 * 自己写快排比复制数组更快
 */
public class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int ans = 0, n = values.length;
        quickSort(values, labels, 0, n - 1);
        int[] table = new int[20001];
        for (int i = 0, count = 0; i < n && count < numWanted; i++) {
            if (table[labels[i]]++ >= useLimit) continue;
            ans += values[i];
            count++;
        }
        return ans;
    }

    private void quickSort(int[] values, int[] labels, int st, int ed) {
        if (st >= ed) return;
        int m = st;
        for (int i = m; i <= ed; i++) {
            if (values[i] >= values[ed]) {
                swap(values, m, i);
                swap(labels, m++, i);
            }
        }
        quickSort(values, labels, st, m - 2);
        quickSort(values, labels, m, ed);
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
