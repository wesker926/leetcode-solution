package com.wesker926.leetcode.algorithms.p1464.s1;

/**
 * @author wesker.gh
 * @date 2022/8/26
 * @description 遍历
 * 维护最大和次大值
 * 注：本题无负数
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int first = -1, second = -2;
        for (int num : nums) {
            if (num >= first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }
        return (first - 1) * (second - 1);
    }
}
