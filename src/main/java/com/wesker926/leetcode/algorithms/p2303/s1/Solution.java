package com.wesker926.leetcode.algorithms.p2303.s1;

/**
 * @author wesker.gh
 * @date 2023/1/23
 * @description 模拟
 * 有一些小优化：
 * 1.pre不需要每次判断，而是每轮赋值（更短）
 * 2.百分比数可以在最后再除以100（减少运算）
 */
public class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        for (int i = 0, pre = 0; i < brackets.length; pre = brackets[i][0], i++) {
            ans += (Math.min(brackets[i][0], income) - pre) * brackets[i][1];
            if (income <= brackets[i][0]) {
                break;
            }
        }
        return ans / 100D;
    }
}
