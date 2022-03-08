package com.wesker926.leetcode.algorithms.p2055.s2;

/**
 * @author wesker.gh
 * @date 2022/3/8
 * @description 前缀和 + 预处理
 */
public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] counts = new int[n], left = new int[n], right = new int[n];
        for (int i = 0, c = 0, l = -1, r = -1; i < n; i++) {
            if (cs[i] == '*') {
                c++;
            } else {
                l = i;
            }

            if (cs[n - 1 - i] == '|') {
                r = n - 1 - i;
            }

            counts[i] = c;
            left[i] = l;
            right[n - 1 - i] = r;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int x = right[q[0]], y = left[q[1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : counts[y] - counts[x];
        }
        return ans;
    }
}
