package com.wesker926.leetcode.algorithms.p0591.s1;

import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/5/2
 * @description 栈 + 遍历
 */
public class Solution {
    public boolean isValid(String code) {
        int n = code.length();
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0, j; i < n; i++) {
            if (code.charAt(i) != '<') {
                if (stack.isEmpty()) {
                    return false;
                }
                continue;
            }

            if (i == n - 1) {
                return false;
            }

            if (code.charAt(i + 1) == '/') {
                j = code.indexOf(">", i);
                if (j < 0) {
                    return false;
                }
                String tag = code.substring(i + 2, j);
                if (stack.isEmpty() || !stack.peekFirst().equals(tag)) {
                    return false;
                }
                stack.pop();
                if (stack.isEmpty() && j != n - 1) {
                    return false;
                }
            } else if (code.charAt(i + 1) == '!') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (i + 12 > n) {
                    return false;
                }
                String cdata = code.substring(i + 2, i + 9);
                if (!cdata.equals("[CDATA[")) {
                    return false;
                }
                j = code.indexOf("]]>", i + 9);
                if (j < 0) {
                    return false;
                }
            } else {
                j = code.indexOf(">", i);
                if (j < 0) {
                    return false;
                }
                String tag = code.substring(i + 1, j);
                if (tag.length() < 1 || tag.length() > 9) {
                    return false;
                }
                for (int k = 0; k < tag.length(); k++) {
                    if (!Character.isUpperCase(tag.charAt(k))) {
                        return false;
                    }
                }
                stack.push(tag);
            }
            i = j;
        }
        return stack.isEmpty();
    }
}
