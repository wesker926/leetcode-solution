package com.wesker926.leetcode.algorithms.p1653.s1;

/**
 * @author wesker.gh
 * @date 2023/3/6
 * @description 递归压栈
 */
public class Solution {
    public int minimumDeletions(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            countA += 'b' - s.charAt(i);
        }
        return min(s.toCharArray(), 0, countA);
    }

    private int min(char[] s, int st, int countA) {
        for (; st < s.length && s[st] == 'a'; st++) {
            countA--;
        }
        if (countA == 0) {
            return 0;
        }
        int countB = 0;
        for (; s[st] == 'b'; st++) {
            countB++;
        }
        return Math.min(countA, countB + min(s, st, countA));
    }
}
