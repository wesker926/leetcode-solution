package com.wesker926.leetcode.algorithms.p0402.s1;

/**
 * @author wesker.gh
 * @date 2022/6/24
 * @description 单调栈
 * 入栈过程中移除栈顶更大的数字，保持栈递增
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        int idx = 0;
        char[] stack = new char[num.length()];
        for (int i = 0; i < num.length(); i++) {
            for (; idx > 0 && stack[idx - 1] > num.charAt(i) && k > 0; idx--, k--) {
            }
            stack[idx++] = num.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx - k; i++) {
            if (sb.length() != 0 || stack[i] != '0') {
                sb.append(stack[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
