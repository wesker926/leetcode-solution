package com.wesker926.leetcode.algorithms.p2028.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/3/27
 * @description 模拟
 */
public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int r : rolls) {
            sum += r;
        }
        sum = mean * (rolls.length + n) - sum;
        if (sum < n || sum > n * 6) {
            return new int[0];
        }

        int a = sum / n, b = sum % n;
        int[] ans = new int[n];
        Arrays.fill(ans, a);
        for (int i = 0; i < b; i++) {
            ans[i]++;
        }
        return ans;
    }
}
