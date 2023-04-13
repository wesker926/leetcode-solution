package com.wesker926.leetcode.algorithms.p2404.s1;

/**
 * @author wesker.gh
 * @date 2023/4/13
 * @description 遍历
 */
public class Solution {
    public int mostFrequentEven(int[] nums) {
        int ans = -1;
        int[] table = new int[50001];
        for (int num : nums) {
            if ((num & 1) == 1) {
                continue;
            }
            num >>= 1;
            if (ans == -1 || (++table[num]) > table[ans] || (table[num] == table[ans] && num < ans)) {
                ans = num;
            }
        }
        return ans < 0 ? -1 : (ans << 1);
    }
}
