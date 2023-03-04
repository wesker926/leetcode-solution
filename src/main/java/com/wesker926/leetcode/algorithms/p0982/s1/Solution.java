package com.wesker926.leetcode.algorithms.p0982.s1;

/**
 * @author wesker.gh
 * @date 2023/3/4
 * @description 枚举
 * 枚举优化：
 * 1.预处理一个数，将O(n^3)降低为O(n ^ 2 + 2 ^ 16 * n)，本题中2 ^ 16是小于n ^ 2的；
 * 2.二进制子集枚举技巧，sub = x & (sub - 1)可以枚举x的每一个二进制子集，平均2 ^ 8次，最坏2 ^ 16次。
 */
public class Solution {
    public int countTriplets(int[] nums) {
        int ans = 0, n = nums.length, total = 1 << 16;
        int[] table = new int[total];
        for (int num : nums) {
            int xor = (total - 1) ^ num;
            for (int i = xor; i > 0; i = xor & (i - 1)) {
                table[i]++;
            }
            table[0]++;
        }
        for (int num1 : nums) {
            for (int num2 : nums) {
                ans += table[num1 & num2];
            }
        }
        return ans;
    }
}
