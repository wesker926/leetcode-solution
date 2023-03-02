package com.wesker926.leetcode.igc.p05_02.s1;

/**
 * @author wesker.gh
 * @date 2023/3/2
 * @description GCD判断是否可以表示
 */
public class Solution {
    public String printBin(double num) {
        int d = 1000000, n = (int) (num * d);
        for (; n % 10 == 0; n /= 10, d /= 10) ;
        int g = d / gcd(n, d);
        if ((g & (g - 1)) != 0) {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder("0.");
        for (num *= 2; num != 0; num *= 2) {
            sb.append((int) num);
            num -= (int) num;
        }
        return sb.toString();
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
