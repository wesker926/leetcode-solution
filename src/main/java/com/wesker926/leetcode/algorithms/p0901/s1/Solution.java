package com.wesker926.leetcode.algorithms.p0901.s1;

/**
 * @author wesker.gh
 * @date 2022/10/21
 * @description 单调栈
 * 维护严格递减的单调栈，当前元素idx减栈顶元素idx即为所求
 */
public class Solution {

    private int idx, cur;

    private final int[][] stack;

    public Solution() {
        idx = cur = 0;
        stack = new int[10000][];
    }

    public int next(int price) {
        for (; idx > 0 && price >= stack[idx - 1][0]; idx--) {
        }
        int ans = idx == 0 ? cur + 1 : cur - stack[idx - 1][1];
        stack[idx++] = new int[]{price, cur++};
        return ans;
    }
}
