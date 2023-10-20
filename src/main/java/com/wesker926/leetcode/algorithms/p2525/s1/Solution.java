package com.wesker926.leetcode.algorithms.p2525.s1;

/**
 * @author wesker.gh
 * @date 2023/10/20
 * @description 数学模拟
 */
public class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky, isHeavy = mass >= 100;
        isBulky = length >= 1e4 || width >= 1e4 || height >= 1e4 || (long) length * width * height >= 1e9;
        return isBulky && isHeavy ? "Both" : (isBulky ? "Bulky" : (isHeavy ? "Heavy" : "Neither"));
    }
}
