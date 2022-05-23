package com.wesker926.leetcode.algorithms.p0137.s1;

/**
 * @author wesker.gh
 * @date 2022/5/23
 * @description 逐位计算
 * 找到count不能整除3的那些位
 * 还有更优的数字电路解法，那个已经看不懂了
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            if (count % 3 != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
