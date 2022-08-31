package com.wesker926.leetcode.algorithms.p0946.s1;

/**
 * @author wesker.gh
 * @date 2022/8/31
 * @description 栈模拟
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0, n = pushed.length;
        int[] stack = new int[n];
        for (int num : pushed) {
            stack[i++] = num;
            for (; i > 0 && stack[i - 1] == popped[j]; i--, j++) {
            }
        }
        return i == 0;
    }
}
