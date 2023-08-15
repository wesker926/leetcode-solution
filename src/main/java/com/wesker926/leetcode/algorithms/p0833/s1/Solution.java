package com.wesker926.leetcode.algorithms.p0833.s1;

/**
 * @author wesker.gh
 * @date 2023/8/15
 * @description 排序 + 模拟
 */
public class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int idx = 0, n = indices.length;
        sort(indices, sources, targets, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        outer:
        for (int i = 0; i < n; i++) {
            sb.append(s, idx, indices[i]);
            idx = indices[i];
            if (s.length() - indices[i] < sources[i].length()) continue;
            for (int j = 0; j < sources[i].length(); j++) {
                if (s.charAt(indices[i] + j) != sources[i].charAt(j)) continue outer;
            }
            sb.append(targets[i]);
            idx = indices[i] + sources[i].length();
        }
        return sb.append(s, idx, s.length()).toString();
    }

    private void sort(int[] a1, String[] a2, String[] a3, int l, int r) {
        if (l >= r) return;
        int i = l;
        for (int j = l, k = a1[r]; j <= r; j++) {
            if (a1[j] <= k) {
                swap(a1, i, j);
                swap(a2, i, j);
                swap(a3, i++, j);
            }
        }
        sort(a1, a2, a3, l, i - 2);
        sort(a1, a2, a3, i, r);
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private <T> void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
