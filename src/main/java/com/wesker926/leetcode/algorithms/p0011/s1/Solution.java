package com.wesker926.leetcode.algorithms.p0011.s1;

/**
 * @author wesker.gh
 * @date 2022/4/21
 * @description 双指针
 */
public class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
