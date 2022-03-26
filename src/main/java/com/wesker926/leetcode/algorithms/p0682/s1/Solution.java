package com.wesker926.leetcode.algorithms.p0682.s1;

/**
 * @author wesker.gh
 * @date 2022/3/26
 * @description 栈
 */
public class Solution {
    public int calPoints(String[] ops) {
        int ans = 0, idx = 0;
        int[] stack = new int[ops.length];
        for (String s : ops) {
            switch (s) {
                case "+": {
                    stack[idx] = stack[idx - 1] + stack[idx - 2];
                    ans += stack[idx++];
                    break;
                }
                case "D": {
                    stack[idx] = stack[idx - 1] * 2;
                    ans += stack[idx++];
                    break;
                }
                case "C": {
                    ans -= stack[--idx];
                    break;
                }
                default: {
                    stack[idx] = Integer.parseInt(s);
                    ans += stack[idx++];
                }
            }
        }
        return ans;
    }
}
