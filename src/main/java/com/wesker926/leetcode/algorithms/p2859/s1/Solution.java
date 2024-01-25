package com.wesker926.leetcode.algorithms.p2859.s1;

import java.util.List;

/**
 * @author wesker.gh
 * @date 2024/1/25
 * @description 遍历
 * next_permutation：Gosper's Hack算法
 * 次优的方法是枚举全组合然后popcount计算置位个数
 */
public class Solution {
    // 标准Gosper's Hack算法
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        if (k == 0) return nums.get(0);
        int res = 0, n = nums.size();
        for (int i = (1 << k) - 1; i < n; ) {
            res += nums.get(i);
            int lb = i & (-i), hb = i + lb;
            i = ((hb ^ i) / lb >> 2) | hb;
        }
        return res;
    }

    // 运算符更多
    public int sumIndicesWithKSetBits1(List<Integer> nums, int k) {
        if (k == 0) return nums.get(0);
        int res = 0, n = nums.size();
        for (int i = (1 << k) - 1; i < n; ) {
            res += nums.get(i);
            int lb1 = i & (-i), hb = i + lb1, lb2 = hb & (-i);
            i = hb | ((lb2 / lb1 >> 1) - 1);
        }
        return res;
    }
}
