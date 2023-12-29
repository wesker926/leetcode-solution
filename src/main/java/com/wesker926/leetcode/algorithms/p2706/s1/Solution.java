package com.wesker926.leetcode.algorithms.p2706.s1;

/**
 * @author wesker.gh
 * @date 2023/12/29
 * @description 遍历
 */
public class Solution {
    public int buyChoco(int[] prices, int money) {
        int a = 101, b = 101;
        for (int price : prices) {
            if (price < a) {
                b = a;
                a = price;
            } else if (price < b) b = price;
        }
        a = money - a - b;
        return a >= 0 ? a : money;
    }
}
