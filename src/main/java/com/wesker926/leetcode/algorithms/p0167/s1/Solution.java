package com.wesker926.leetcode.algorithms.p0167.s1;

/**
 * @author wesker.gh
 * @date 2022/6/7
 * @description 双指针
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }
}
