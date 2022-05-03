package com.wesker926.leetcode.algorithms.p0071.s1;

/**
 * @author wesker.gh
 * @date 2022/5/3
 * @description 栈
 */
public class Solution {
    public String simplifyPath(String path) {
        char[] origin = (path + '/').toCharArray();
        char[] stack = new char[path.length() + 1];
        int idx = 0;
        stack[idx++] = '/';
        for (int i = 0, c = 0; i < origin.length; i++) {
            if (origin[i] != '/') {
                c++;
                stack[idx++] = origin[i];
                continue;
            }

            if (stack[idx - 1] == '/') {
                continue;
            }

            if (stack[idx - 1] != '.' || (c == 2 && stack[idx - 2] != '.') || c > 2) {
                stack[idx++] = '/';
            } else if (c == 1) {
                idx--;
            } else {
                idx -= 3;
                while (idx > 0 && stack[idx - 1] != '/') {
                    idx--;
                }
                if (idx == 0) {
                    idx++;
                }
            }
            c = 0;
        }
        if (idx != 1 && stack[idx - 1] == '/') {
            idx--;
        }
        return new String(stack, 0, idx);
    }
}
