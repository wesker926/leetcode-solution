package com.wesker926.leetcode.algorithms.p0136.s1;

/**
 * @author wesker.gh
 * @date 2022/5/23
 * @description 异或
 * x ^ 0 = x, x ^ x = 0.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
