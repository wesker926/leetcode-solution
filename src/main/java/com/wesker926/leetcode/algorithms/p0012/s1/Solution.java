package com.wesker926.leetcode.algorithms.p0012.s1;

/**
 * @author wesker.gh
 * @date 2022/4/22
 * @description 模拟
 */
public class Solution {

    private static final String[] STR = new String[]{"I", "V", "X", "L", "C", "D", "M"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int n = 1000, i = STR.length - 1; n > 0; num %= n, n /= 10, i -= 2) {
            int div = num / n;
            if (div == 4 || div == 9) {
                sb.append(STR[i]).append(STR[i + 1 + div / 5]);
            } else {
                if (div >= 5) {
                    sb.append(STR[i + 1]);
                    div -= 5;
                }
                sb.append(STR[i].repeat(div));
            }
        }
        return sb.toString();
    }
}
