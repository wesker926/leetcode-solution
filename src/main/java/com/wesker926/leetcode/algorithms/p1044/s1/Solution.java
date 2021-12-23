package com.wesker926.leetcode.algorithms.p1044.s1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2021/12/23
 * @description 二分 + Rabin-Karp算法
 * 当心 int 溢出
 */
public class Solution {

    private final int a1, a2, m1, m2;

    {
        a1 = randInt(26, 100);
        a2 = randInt(26, 100);
        m1 = randInt((int) 1e9 + 7, Integer.MAX_VALUE);
        m2 = randInt((int) 1e9 + 7, Integer.MAX_VALUE);
    }

    private static final Random random = new Random();

    private static int randInt(int a, int b) {
        return random.nextInt(b - a) + a;
    }

    private static int pow(long a, int b, int m) {
        long res = 1;
        for (; b != 0; b >>= 1) {
            if ((b & 1) == 1) {
                res = (res * a) % m;
            }
            a = (a * a) % m;
        }
        return (int) res;
    }

    public String longestDupSubstring(String s) {
        int l = 0, r = s.length() - 1, m, f;
        int[] arr = new int[s.length()], ans = new int[]{-1, -1};
        for (char c : s.toCharArray()) {
            arr[l++] = c - 'a';
        }
        l = 0;

        while (l <= r) {
            m = l + (r - l) / 2;
            f = find(arr, m);
            if (f == -1) {
                r = m - 1;
            } else {
                l = m + 1;
                ans[0] = f;
                ans[1] = m;
            }
        }

        return ans[0] == -1 ? "" : s.substring(ans[0], ans[0] + ans[1]);
    }

    private int find(int[] arr, int n) {
        long h1 = pow(a1, n, m1), h2 = pow(a2, n, m2), c1 = 0, c2 = 0, c;
        for (int i = 0; i < n; i++) {
            c1 = (c1 * a1 + arr[i]) % m1;
            c2 = (c2 * a2 + arr[i]) % m2;
        }

        Set<Long> set = new HashSet<>();
        set.add(c1 * m2 + c2);
        for (int start = n; start < arr.length; start++) {
            c1 = (c1 * a1 - arr[start - n] * h1 + arr[start]) % m1;
            c1 = c1 < 0 ? c1 + m1 : c1;
            c2 = (c2 * a2 - arr[start - n] * h2 + arr[start]) % m2;
            c2 = c2 < 0 ? c2 + m2 : c2;

            c = c1 * m2 + c2;
            if (!set.add(c)) {
                return start - n + 1;
            }
        }
        return -1;
    }
}
