package com.wesker926.leetcode.algorithms.p2578.s1;

/**
 * @author wesker.gh
 * @date 2023/10/9
 * @description 贪心
 */
public class Solution {
    public int splitNum(int num) {
        int[] table = new int[10];
        for (; num > 0; num /= 10) table[num % 10]++;
        int[] ans = new int[2];
        for (int i = 1, idx = 0; i < table.length; ) {
            if (table[i]-- > 0) {
                ans[idx] = ans[idx] * 10 + i;
                idx = 1 - idx;
            }
            if (table[i] <= 0) i++;
        }
        return ans[0] + ans[1];
    }
}
