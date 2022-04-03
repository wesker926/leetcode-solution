package com.wesker926.leetcode.algorithms.p0744.s1;

/**
 * @author wesker.gh
 * @date 2022/4/3
 * @description 二分
 */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1, m;
        while (l <= r) {
            m = (r - l) / 2 + l;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return letters[l >= letters.length ? 0 : l];
    }
}
