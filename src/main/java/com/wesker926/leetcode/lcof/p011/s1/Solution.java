package com.wesker926.leetcode.lcof.p011.s1;

/**
 * @author wesker.gh
 * @date 2022/3/30
 * @description 二分
 */
public class Solution {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        if (numbers[0] < numbers[n - 1]) {
            return numbers[0];
        }

        if (numbers[0] == numbers[n - 1]) {
            int min = numbers[0];
            for (int i = 1; i < n; i++) {
                min = Math.min(min, numbers[i]);
            }
            return min;
        }

        int l = 0, r = n - 1, m;
        while (l <= r) {
            m = (r - l) / 2 + l;
            if (numbers[m] < numbers[0]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return numbers[l];
    }
}
