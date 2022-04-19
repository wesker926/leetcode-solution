package com.wesker926.leetcode.lcof.p061.s1;

/**
 * @author wesker.gh
 * @date 2022/4/19
 * @description 遍历 + Set
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        int max = -1, min = 14;
        int[] count = new int[14];
        for (int num : nums) {
            count[num]++;
            if (num != 0) {
                if (count[num] > 1) {
                    return false;
                }
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
        }
        return max - min < 5;
    }
}
