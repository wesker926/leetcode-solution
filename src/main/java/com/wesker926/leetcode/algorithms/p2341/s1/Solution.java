package com.wesker926.leetcode.algorithms.p2341.s1;

/**
 * @author wesker.gh
 * @date 2023/2/16
 * @description 哈希表
 */
public class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] table = new int[101], ans = new int[2];
        for (int num : nums) {
            table[num]++;
        }
        for (int count : table) {
            ans[1] += count & 1;
        }
        ans[0] = (nums.length - ans[1]) >> 1;
        return ans;
    }
}
