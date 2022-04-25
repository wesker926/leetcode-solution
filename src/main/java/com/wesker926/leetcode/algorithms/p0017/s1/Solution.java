package com.wesker926.leetcode.algorithms.p0017.s1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/25
 * @description 回溯
 */
public class Solution {

    private static final char[][] map = new char[][]{
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        return digits.length() == 0 ? new ArrayList<>() : dfs(new LinkedList<>(), new char[digits.length()], digits.toCharArray(), 0);
    }

    private List<String> dfs(List<String> ans, char[] cur, char[] digits, int idx) {
        if (idx == digits.length) {
            ans.add(new String(cur));
        } else {
            for (char c : map[digits[idx] - '2']) {
                cur[idx] = c;
                dfs(ans, cur, digits, idx + 1);
            }
        }
        return ans;
    }
}
