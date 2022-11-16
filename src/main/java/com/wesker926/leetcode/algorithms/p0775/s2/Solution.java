package com.wesker926.leetcode.algorithms.p0775.s2;

/**
 * @author wesker.gh
 * @date 2022/11/16
 * @description 数学归纳
 * 不存在非局部倒置的充要条件是：一个数字num和它的坐标i的差值不能大于1
 * 可从0开始，然后问题可转化为[1,n-1]或[2,n-1]的子问题
 * 该解法利用了nums是0~n-1的排列的这一特性
 */
public class Solution {
    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}
