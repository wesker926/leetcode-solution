package com.wesker926.leetcode.algorithms.p1995.s3;

/**
 * @author wesker.gh
 * @date 2021/12/29
 * @description 遍历 + 桶
 */
public class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        int[] bucket = new int[301];
        for (int b = n - 3; b >= 1; b--) {
            for (int d = n - 1; d >= b + 2; d--) {
                bucket[nums[d] - nums[b + 1] + 100]++;
            }
            for (int a = 0; a < b; a++) {
                ans += bucket[nums[a] + nums[b] + 100];
            }
        }
        return ans;
    }
}
