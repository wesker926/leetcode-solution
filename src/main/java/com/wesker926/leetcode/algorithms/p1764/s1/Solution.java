package com.wesker926.leetcode.algorithms.p1764.s1;

/**
 * @author wesker.gh
 * @date 2022/12/17
 * @description 贪心 + KMP
 * 贪心思路，group[i]按顺序与nums匹配，不可以相交
 * 单个group匹配过程等价于寻找字符串子串
 * 可将暴力匹配优化为KMP算法
 */
public class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0, st = 0; i < groups.length; i++) {
            if (groups[i].length > nums.length - st) {
                return false;
            }
            st = kmp(nums, st, groups[i], dp);
            if (st < 0) {
                return false;
            }
        }
        return true;
    }

    private int kmp(int[] nums, int st, int[] group, int[] dp) {
        for (int i = 1, j = 0; i < group.length; i++) {
            while (j > 0 && group[i] != group[j]) {
                j = dp[j - 1];
            }
            if (group[i] == group[j]) {
                j++;
            }
            dp[i] = j;
        }
        for (int i = st, j = 0; i < nums.length; i++) {
            while (j != 0 && nums[i] != group[j]) {
                j = dp[j - 1];
            }
            if (nums[i] == group[j]) {
                j++;
            }
            if (j == group.length) {
                return i + 1;
            }
        }
        return -1;
    }
}
