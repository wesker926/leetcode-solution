package com.wesker926.leetcode.algorithms.p0856.s1;

/**
 * @author wesker.gh
 * @date 2022/10/9
 * @description 栈
 */
public class Solution {
    public int scoreOfParentheses(String s) {
        int[] stack = new int[s.length()];
        int idx = 0, cur, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[idx++] = -1;
                continue;
            }
            if (stack[idx - 1] == -1) {
                stack[idx - 1] = 1;
                continue;
            }
            for (cur = 0, idx--; stack[idx] != -1; idx--) {
                cur += stack[idx];
            }
            stack[idx++] = cur * 2;
        }
        for (int i = 0; i < idx; i++) {
            ans += stack[i];
        }
        return ans;
    }
}
