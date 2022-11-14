package com.wesker926.leetcode.algorithms.p0805.s1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2022/11/14
 * @description 折半搜索
 * 如果n不大，但是又没法直接进行2^n级别的状态遍历时，就可以使用这个方法。
 * 1.预处理后的数组sum为0，则题目转换为划分两个和为0的分区；
 * 2.两个分区分别遍历，左分区记录每种状态的sum，右分区额外找-sum；
 * 3.右分区找-sum时不可取全部数字，同时右分区找0sum时没必要取全部数字（左分区可以涵盖），因此右分区不需要考虑包含全部数字的状态；
 */
public class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length, sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - sum;
        }
        int l = (n + 1) / 2, r = n - l;
        Set<Integer> set = new HashSet<>();
        return find(nums, l, true, set) || find(nums, r, false, set);
    }

    private boolean find(int[] nums, int len, boolean leftPartition, Set<Integer> set) {
        int l = leftPartition ? 0 : nums.length - len;
        for (int i = 1; i < (1 << len); i++) {
            if (!leftPartition && i == (1 << len) - 1) {
                continue;
            }
            int total = 0;
            for (int j = 0; j < len; j++) {
                if (((i >> j) & 1) != 0) {
                    total += nums[l + j];
                }
            }
            if (total == 0 || (!leftPartition && set.contains(-total))) {
                return true;
            }
            if (leftPartition) {
                set.add(total);
            }
        }
        return false;
    }
}
