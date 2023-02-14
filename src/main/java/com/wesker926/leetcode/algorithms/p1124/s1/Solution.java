package com.wesker926.leetcode.algorithms.p1124.s1;

/**
 * @author wesker.gh
 * @date 2023/2/14
 * @description 贪心（前缀和 + 单调栈）
 * 好题，滑不出来。
 * 本题的前提是前缀和，难点是如何将暴力枚举前缀和优化为线性复杂度。
 * 本题可转化为寻找 pre[i] - pre[j] > 0，i > j。
 * 因此对于每个pre[i]，寻找其前方最远的pre[j]即可，可使用单调栈。
 * 为了避免出栈后还要入栈，本题先得出单调栈，然后倒序遍历pre[i]，这不同于通常意义的单调栈。
 * 其正确性显而易见。
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
