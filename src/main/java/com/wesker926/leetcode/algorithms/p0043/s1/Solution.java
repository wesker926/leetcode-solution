package com.wesker926.leetcode.algorithms.p0043.s1;

/**
 * @author wesker.gh
 * @date 2022/4/29
 * @description 逐位乘后统一进位
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        char[] cs1 = num1.toCharArray(), cs2 = num2.toCharArray();
        int[] ans = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            if (cs1[i] == '0') {
                continue;
            }
            for (int j = n - 1; j >= 0; j--) {
                if (cs2[j] == '0') {
                    continue;
                }
                ans[i + j + 1] += (cs1[i] - '0') * (cs2[j] - '0');
            }
        }
        for (int i = ans.length - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = ans[0] == 0 ? 1 : 0; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
