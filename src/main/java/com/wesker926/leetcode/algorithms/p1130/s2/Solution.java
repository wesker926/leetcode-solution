package com.wesker926.leetcode.algorithms.p1130.s2;

/**
 * @author wesker.gh
 * @date 2023/5/31
 * @description 贪心
 * 问题可以转化为：给定一个数组arr，不断地合并相邻的数，合并代价为两个数的乘积，合并之后的数为两个数的最大值，直到数组只剩一个数，求最小合并代价和。
 * 可以参考哈夫曼树的结构
 */
public class Solution {
    public int mctFromLeafValues(int[] arr) {
        int idx = 0, ans = 0;
        int[] stack = new int[arr.length + 1];
        stack[idx++] = Integer.MAX_VALUE;
        for (int num : arr) {
            while (stack[idx - 1] < num) {
                ans += stack[--idx] * Math.min(stack[idx - 1], num);
            }
            stack[idx++] = num;
        }
        while (idx > 2) ans += stack[--idx] * stack[idx - 1];
        return ans;
    }
}
