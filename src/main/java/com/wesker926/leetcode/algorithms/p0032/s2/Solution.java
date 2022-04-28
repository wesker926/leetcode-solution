package com.wesker926.leetcode.algorithms.p0032.s2;

/**
 * @author wesker.gh
 * @date 2022/4/28
 * @description 双计数
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), ans = 0;
        char[] cs = s.toCharArray();
        for (int i = 0, ll = 0, lr = 0, rl = 0, rr = 0; i < n; i++) {
            if (cs[i] == '(') {
                ll++;
            } else {
                lr++;
            }
            if (ll == lr) {
                ans = Math.max(ans, ll + lr);
            } else if (ll < lr) {
                ll = lr = 0;
            }

            if (cs[n - 1 - i] == '(') {
                rl++;
            } else {
                rr++;
            }
            if (rl == rr) {
                ans = Math.max(ans, rl + rr);
            } else if (rl > rr) {
                rl = rr = 0;
            }
        }
        return ans;
    }
}
