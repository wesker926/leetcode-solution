package com.wesker926.leetcode.igc.p05_02.s2;

/**
 * @author wesker.gh
 * @date 2023/3/2
 * @description 数学
 * 可以证明如果符合题目要求，则必为6位二进制
 */
public class Solution {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        for (num *= 2; sb.length() <= 8 && num != 0; num *= 2) {
            sb.append((int) num);
            num -= (int) num;
        }
        return sb.length() > 8 ? "ERROR" : sb.toString();
    }
}
