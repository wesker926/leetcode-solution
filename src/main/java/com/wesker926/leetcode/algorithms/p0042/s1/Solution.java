package com.wesker926.leetcode.algorithms.p0042.s1;

/**
 * @author wesker.gh
 * @date 2022/4/29
 * @description 双指针
 */
public class Solution {
    public int trap(int[] height) {
        int ans = 0, n = height.length;
        for (int i = 0, j = n - 1, k; i < j; ) {
            if (height[i] <= height[j]) {
                for (k = i + 1; k < j && height[k] < height[i]; k++) {
                    ans += height[i] - height[k];
                }
                i = k;
            } else {
                for (k = j - 1; k > i && height[k] < height[j]; k--) {
                    ans += height[j] - height[k];
                }
                j = k;
            }
        }
        return ans;
    }
}
