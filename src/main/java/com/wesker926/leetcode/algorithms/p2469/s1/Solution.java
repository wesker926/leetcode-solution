package com.wesker926.leetcode.algorithms.p2469.s1;

/**
 * @author wesker.gh
 * @date 2023/3/21
 * @description 模拟
 */
public class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
