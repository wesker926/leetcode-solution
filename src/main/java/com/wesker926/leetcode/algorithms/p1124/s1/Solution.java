package com.wesker926.leetcode.algorithms.p1124.s1;

/**
 * @author wesker.gh
 * @date 2023/2/14
 * @description 贪心（前缀和 + 单调栈）
 * 好题，滑不了。
 * 不同于通常意义的单调栈，这题的栈是先得出，后使用。
 */
public class Solution {
    public int longestWPI(int[] hours) {
        int max = 0, n = hours.length, idx = 1;
        int[] pre = new int[n + 1], stack = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (hours[i] > 8 ? 1 : -1);
        }
        for (int i = 1; i <= n; i++) {
            if (pre[stack[idx - 1]] > pre[i]) {
                stack[idx++] = i;
            }
        }
        for (int i = n; i >= 0 && idx > 0; i--) {
            int tar = i;
            while (idx > 0 && pre[stack[idx - 1]] < pre[i]) {
                tar = stack[--idx];
            }
            max = Math.max(max, i - tar);
        }
        return max;
    }
}
