package com.wesker926.leetcode.algorithms.p2605.s1;

/**
 * @author wesker.gh
 * @date 2023/9/5
 * @description 遍历
 */
public class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int min1 = 10, min2 = 10, min3 = 10;
        int[] exist = new int[10];
        for (int num : nums1) min1 = Math.min(min1, exist[num] = num);
        for (int num : nums2) {
            if (exist[num] != 0) min3 = Math.min(min3, num);
            min2 = Math.min(min2, num);
        }
        return min3 != 10 ? min3 : (min1 < min2 ? min1 * 10 + min2 : min2 * 10 + min1);
    }
}
