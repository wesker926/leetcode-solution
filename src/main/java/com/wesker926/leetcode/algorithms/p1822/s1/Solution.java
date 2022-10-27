package com.wesker926.leetcode.algorithms.p1822.s1;

/**
 * @author wesker.gh
 * @date 2022/10/27
 * @description 遍历
 */
public class Solution {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                ans = -ans;
            }
        }
        return ans;
    }
}
