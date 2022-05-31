package com.wesker926.leetcode.algorithms.p0198.s1;

/**
 * @author wesker.gh
 * @date 2022/5/31
 * @description DP
 * 记录[0, i]范围下，偷i或不偷i情况的两种结果
 */
public class Solution {
    public int rob(int[] nums) {
        int select = 0, notSelect = 0;
        for (int num : nums) {
            int temp = select;
            select = num + notSelect;
            notSelect = Math.max(temp, notSelect);
        }
        return Math.max(select, notSelect);
    }
}
