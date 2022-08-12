package com.wesker926.leetcode.algorithms.p0768.s1;

/**
 * @author wesker.gh
 * @date 2022/8/13
 * @description 左右最值
 * 如果左侧最大值不大于右侧最小值，则左侧右边界处可以切分
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, ans = 1;
        int[] max = new int[n], min = new int[n];
        max[0] = arr[0];
        min[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], arr[i]);
            min[n - i - 1] = Math.min(min[n - i], arr[n - i - 1]);
        }
        for (int i = 0; i < n - 1; i++) {
            if (max[i] <= min[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
}
