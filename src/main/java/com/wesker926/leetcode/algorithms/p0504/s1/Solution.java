package com.wesker926.leetcode.algorithms.p0504.s1;

/**
 * @author wesker.gh
 * @date 2022/4/27
 * @description 计算
 */
public class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        for (int a = Math.abs(num); a != 0; a /= 7) {
            sb.append(a % 7);
        }
        return num == 0 ? "0" : sb.append(num < 0 ? '-' : "").reverse().toString();
    }
}
