package com.wesker926.leetcode.algorithms.p2455.s1;

/**
 * @author wesker.gh
 * @date 2023/5/29
 * @description 遍历
 * 是2的倍数，也是3的倍数，因此模6
 */
public class Solution {
    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for (int num : nums) {
            if (num % 6 != 0) continue;
            sum += num;
            count++;
        }
        return count == 0 ? 0 : sum / count;
    }
}
