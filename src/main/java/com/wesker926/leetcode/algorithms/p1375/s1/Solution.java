package com.wesker926.leetcode.algorithms.p1375.s1;

/**
 * @author wesker.gh
 * @date 2023/6/14
 * @description 遍历
 */
public class Solution {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0;
        for (int i = 0, max = 0; i < flips.length; i++)
            if ((max = Math.max(max, flips[i])) == i + 1) ans++;
        return ans;
    }

    public int numTimesAllBlue1(int[] flips) {
        int ans = 0, n = flips.length;
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[Math.max(flips[i - 1], i)]++;
            if ((arr[i] += arr[i - 1]) == i) ans++;
        }
        return ans;
    }
}
