package com.wesker926.leetcode.algorithms.p1748.s1;

/**
 * @author wesker.gh
 * @date 2022/2/6
 * @description 遍历
 */
public class Solution {
    public int sumOfUnique(int[] nums) {
        int ans = 0;
        int[] bucket = new int[101];
        for (int i : nums) {
            if (bucket[i] == 0) {
                ans += i;
            } else if (bucket[i] == 1) {
                ans -= i;
            }
            bucket[i]++;
        }
        return ans;
    }
}
