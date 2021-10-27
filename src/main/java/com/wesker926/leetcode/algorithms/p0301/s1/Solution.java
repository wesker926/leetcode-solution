package com.wesker926.leetcode.algorithms.p0301.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2021/10/27
 * @description dfs
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int lr = 0, rr = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lr++;
            } else if (c == ')') {
                if (lr == 0) {
                    rr++;
                } else {
                    lr--;
                }
            }
        }

        List<String> result = new LinkedList<>();
        dfs(result, s, 0, 0, 0, lr, rr);
        return result;
    }

    private void dfs(List<String> result, String str, int start, int lc, int rc, int lr, int rr) {
        if (lr == 0 && rr == 0) {
            if (valid(str)) {
                result.add(str);
            }
            return;
        }

        char[] cs = str.toCharArray();
        for (int i = start; i < cs.length; i++) {
            if (cs[i] != '(' && cs[i] != ')') {
                continue;
            }

            if (cs.length - i < lr + rr) {
                return;
            }

            boolean left = cs[i] == '(';
            if (i == start || cs[i] != cs[i - 1]) {
                String s = new String(cs, 0, i) + new String(cs, i + 1, cs.length - i - 1);
                if (lr > 0 && left) {
                    dfs(result, s, i, lc, rc, lr - 1, rr);
                }

                if (rr > 0 && !left) {
                    dfs(result, s, i, lc, rc, lr, rr - 1);
                }
            }

            lc = left ? lc + 1 : lc;
            rc = left ? rc : rc + 1;
            if (rc > lc) {
                return;
            }
        }
    }

    private boolean valid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
