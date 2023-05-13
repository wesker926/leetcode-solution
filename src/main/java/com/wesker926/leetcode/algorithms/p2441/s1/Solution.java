package com.wesker926.leetcode.algorithms.p2441.s1;

/**
 * @author wesker.gh
 * @date 2023/5/13
 * @description 遍历
 */
public class Solution {
    public int findMaxK(int[] nums) {
        int ans = -1;
        boolean[] table = new boolean[2001];
        for (int num : nums) {
            table[num + 1000] = true;
            if (table[1000 - num]) ans = Math.max(ans, Math.abs(num));
        }
        return ans;
    }
}
