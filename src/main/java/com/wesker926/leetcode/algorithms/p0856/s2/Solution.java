package com.wesker926.leetcode.algorithms.p0856.s2;

/**
 * @author wesker.gh
 * @date 2022/10/9
 * @description 栈思想
 * 标记替代栈，因为仅()为实际的数字，其他为放大或累加
 */
public class Solution {
    public int scoreOfParentheses(String s) {
        int cur = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cur = cur == 0 ? 1 : cur << 1;
            } else {
                if (s.charAt(i - 1) == '(') {
                    ans += cur;
                }
                cur >>= 1;
            }
        }
        return ans;
    }
}
