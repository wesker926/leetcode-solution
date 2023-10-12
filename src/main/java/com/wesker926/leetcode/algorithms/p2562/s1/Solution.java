package com.wesker926.leetcode.algorithms.p2562.s1;

/**
 * @author wesker.gh
 * @date 2023/10/12
 * @description 模拟
 */
public class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int cur = 0, factor = 1;
            for (int num : new int[]{nums[j], nums[i]})
                for (; num > 0; num /= 10, factor *= 10)
                    cur += (num % 10) * factor;
            ans += cur;
        }
        return ans + ((n & 1) == 0 ? 0 : nums[n >> 1]);
    }
}
