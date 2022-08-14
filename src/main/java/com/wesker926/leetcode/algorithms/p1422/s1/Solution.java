package com.wesker926.leetcode.algorithms.p1422.s1;

/**
 * @author wesker.gh
 * @date 2022/8/14
 * @description 两次遍历
 */
public class Solution {
    public int maxScore(String s) {
        int score = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            score += s.charAt(i) - '0';
        }
        for (int i = 0; i < s.length() - 1; i++) {
            score += s.charAt(i) == '0' ? 1 : -1;
            ans = Math.max(ans, score);
        }
        return ans;
    }
}
