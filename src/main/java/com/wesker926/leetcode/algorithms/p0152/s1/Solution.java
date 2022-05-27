package com.wesker926.leetcode.algorithms.p0152.s1;

/**
 * @author wesker.gh
 * @date 2022/5/27
 * @description DP
 * 维护以当前num为结尾的子数组的最大最小乘积
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, max = 1, min = 1, temp;
        for (int num : nums) {
            temp = max;
            max = num == 0 ? 0 : (num > 0 ? Math.max(num, num * max) : Math.max(num, num * min));
            min = num == 0 ? 0 : (num > 0 ? Math.min(num, num * min) : Math.min(num, num * temp));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
