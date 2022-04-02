package com.wesker926.leetcode.lcof.p017.s1;

/**
 * @author wesker.gh
 * @date 2022/4/2
 * @description 普通版不考虑大数
 */
public class Solution {
    public int[] printNumbers(int n) {
        int[] ans = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
