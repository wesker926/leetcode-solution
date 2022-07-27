package com.wesker926.leetcode.algorithms.p0592.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/7/27
 * @description 计算
 * 用到了GCD
 */
public class Solution {
    public String fractionAddition(String expression) {
        int idx = 0;
        long mul = 1, sum = 0;
        int[] nums = new int[20];
        for (int i = 0, num = 0, sign = 1; i <= expression.length(); i++) {
            if (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + expression.charAt(i) - '0';
                continue;
            }
            if (num != 0) {
                if ((idx & 1) == 1) {
                    mul *= num;
                    nums[idx++] = num;
                } else {
                    nums[idx++] = num * sign;
                }
            }
            num = 0;
            sign = i == expression.length() || expression.charAt(i) == '+' ? 1 : -1;
        }
        for (int i = 0; i < idx; i += 2) {
            sum += nums[i] * mul / nums[i + 1];
        }
        long gcd = gcd(Math.abs(sum), mul);
        return (sum / gcd) + "/" + (mul / gcd);
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
