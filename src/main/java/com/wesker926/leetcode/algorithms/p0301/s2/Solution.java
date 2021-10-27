package com.wesker926.leetcode.algorithms.p0301.s2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2021/10/27
 * @description bfs
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();
        Set<String> set = new HashSet<>(), temp;
        char[] cs;

        set.add(s);
        while (true) {
            for (String str : set) {
                if (valid(str)) {
                    result.add(str);
                }
            }

            if (!result.isEmpty()) {
                return result;
            }

            temp = new HashSet<>();
            for (String str : set) {
                cs = str.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    if (i != 0 && cs[i] == cs[i - 1]) {
                        continue;
                    }

                    if (cs[i] == '(' || cs[i] == ')') {
                        temp.add(new String(cs, 0, i) + new String(cs, i + 1, cs.length - i - 1));
                    }
                }
            }
            set = temp;
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
