package com.wesker926.leetcode.algorithms.p2251.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/9/28
 * @description 二分
 * https://leetcode.cn/problems/number-of-flowers-in-full-bloom/solutions/2457828/hua-qi-nei-hua-de-shu-mu-by-leetcode-sol-j94l/?envType=daily-question&envId=2023-09-28
 */
public class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int m = flowers.length, n = people.length;
        int[] start = new int[m], end = new int[m];
        for (int i = 0; i < flowers.length; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[] ans = new int[n];
        for (int i = 0; i < people.length; i++)
            ans[i] = binary(start, people[i]) - binary(end, people[i] - 1);
        return ans;
    }

    private int binary(int[] arr, int t) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
