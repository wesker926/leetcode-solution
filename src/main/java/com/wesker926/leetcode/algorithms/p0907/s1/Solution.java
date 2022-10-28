package com.wesker926.leetcode.algorithms.p0907.s1;

/**
 * @author wesker.gh
 * @date 2022/10/28
 * @description 单调栈
 * 使用单调栈来找到数x左右的更小数的位置
 * 类似于：
 * 主站-p0084：柱状图中最大的矩形
 * 主站-p0085：最大矩形
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        int idx = 0;
        int[] stack = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            for (; idx != 0 && arr[stack[idx - 1]] >= arr[i]; idx--) {
                int cur = stack[idx - 1];
                long pre = idx < 2 ? -1 : stack[idx - 2];
                ans = (ans + (cur - pre) * (i - cur) * arr[cur]) % MOD;
            }
            stack[idx++] = i;
        }
        for (int i = 0; i < idx; i++) {
            long pre = i == 0 ? -1 : stack[i - 1];
            ans = (ans + (stack[i] - pre) * (arr.length - stack[i]) * arr[stack[i]]) % MOD;
        }
        return (int) ans;
    }
}
