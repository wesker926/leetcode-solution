package com.wesker926.leetcode.algorithms.p0769.s2;

/**
 * @author wesker.gh
 * @date 2022/10/13
 * @description 贪心
 * 如果最大值等于当前idx，相当于这一块儿可以独立了
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ans++;
            }
        }
        return ans;
    }
}
