package com.wesker926.leetcode.algorithms.p2055.s1;

/**
 * @author wesker.gh
 * @date 2022/3/8
 * @description 二分
 */
public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] counts = new int[n];
        for (int i = 0, c = 0; i < n; i++) {
            c = cs[i] == '|' ? c + 1 : c;
            counts[i] = c;
        }

        int idx = 0;
        int[] ans = new int[queries.length];
        for (int[] q : queries) {
            int l = cs[q[0]] == '|' ? q[0] : binary(counts, q[0], q[1], counts[q[0]] + 1);
            int r = binary(counts, q[0], q[1], counts[q[1]]);
            ans[idx++] = l < 0 || r < 0 ? 0 : r - l + counts[l] - counts[r];
        }
        return ans;
    }

    private int binary(int[] arr, int s, int e, int t) {
        int l = s, r = e, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if ((l == s && arr[l] != t) || l == e + 1) {
            return -1;
        }
        return l;
    }
}
