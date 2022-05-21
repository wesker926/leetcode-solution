package com.wesker926.leetcode.algorithms.p0131.s1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/21
 * @description DP预处理 + 回溯
 */
public class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                isPalindrome[i][j] = (i == j) || (s.charAt(i) == s.charAt(j) && (j - i == 1 || isPalindrome[i + 1][j - 1]));
            }
        }
        List<List<String>> ans = new LinkedList<>();
        backtracking(isPalindrome, ans, new LinkedList<>(), s.toCharArray(), 0);
        return ans;
    }

    private void backtracking(boolean[][] isPalindrome, List<List<String>> ans, LinkedList<String> cur, char[] cs, int idx) {
        if (idx == cs.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < cs.length; i++) {
            if (isPalindrome[idx][i]) {
                cur.add(new String(cs, idx, i - idx + 1));
                backtracking(isPalindrome, ans, cur, cs, i + 1);
                cur.removeLast();
            }
        }
    }
}
