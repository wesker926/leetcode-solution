package com.wesker926.leetcode.algorithms.p1781.s1;

/**
 * @author wesker.gh
 * @date 2022/12/12
 * @description 双重循环
 * min的计算有些讨厌
 */
public class Solution {
    public int beautySum(String s) {
        int ans = 0;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int max = 0;
            for (int j = i; j < s.length(); j++) {
                max = Math.max(max, ++table[s.charAt(j) - 'a']);
                ans += max;
            }
            int min = getMin(table, s.length());
            for (int j = s.length() - 1; j >= i; j--) {
                ans -= min;
                min = Math.min(min, --table[s.charAt(j) - 'a']);
                min = min > 0 ? min : getMin(table, s.length());
            }
        }
        return ans;
    }

    private int getMin(int[] table, int min) {
        for (int t : table) {
            min = Math.min(min, t > 0 ? t : min);
        }
        return min;
    }
}
