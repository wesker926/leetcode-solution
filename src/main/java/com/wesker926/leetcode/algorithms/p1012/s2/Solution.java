package com.wesker926.leetcode.algorithms.p1012.s2;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/3/20
 * @description 数位DP
 * 数位DP模版 by @灵茶山艾府
 */
public class Solution {
    public int numDupDigitsAtMostN(int n) {
        char[] num = String.valueOf(n).toCharArray();
        int l = num.length;
        int[][] dp = new int[l][1 << 10];
        for (int i = 0; i < l; i++) {
            Arrays.fill(dp[i], -1);
        }
        return n - f(num, dp, 0, 0, true, false);
    }

    private int f(char[] num, int[][] dp, int i, int mask, boolean isLimit, boolean isNum) {
        if (i == num.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][mask] != -1) {
            return dp[i][mask];
        }
        int res = isNum ? 0 : f(num, dp, i + 1, mask, false, false);
        int max = isLimit ? num[i] - '0' : 9;
        for (int j = isNum ? 0 : 1; j <= max; j++) {
            if (((mask >> j) & 1) == 0) {
                res += f(num, dp, i + 1, mask | (1 << j), isLimit && (j == max), true);
            }
        }
        if (!isLimit && isNum) {
            dp[i][mask] = res;
        }
        return res;
    }
}
