package com.wesker926.leetcode.algorithms.p0926.s1;

/**
 * @author wesker.gh
 * @date 2022/6/11
 * @description DP（左右分区）
 */
public class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length(), leftOne = 0, rightZero = n;
        for (int i = 0; i < n; i++) {
            rightZero -= s.charAt(i) - '0';
        }
        int ans = rightZero;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                leftOne++;
            } else {
                rightZero--;
            }
            ans = Math.min(ans, leftOne + rightZero);
        }
        return ans;
    }
}
