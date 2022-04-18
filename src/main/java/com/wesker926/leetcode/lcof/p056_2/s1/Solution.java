package com.wesker926.leetcode.lcof.p056_2.s1;

/**
 * @author wesker.gh
 * @date 2022/4/18
 * @description 位运算
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int bit = 0; bit < 32; bit++, num >>= 1) {
                bits[bit] += num & 1;
            }
        }
        int ans = 0;
        for (int bit = 31; bit >= 0; bit--) {
            ans <<= 1;
            if (bits[bit] % 3 == 1) {
                ans |= 1;
            }
        }
        return ans;
    }
}
