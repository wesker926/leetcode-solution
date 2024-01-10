package com.wesker926.leetcode.algorithms.p2696.s1;

/**
 * @author wesker.gh
 * @date 2024/1/10
 * @description 栈
 */
public class Solution {
    public int minLength(String s) {
        int n = s.length(), idx = 0;
        char[] sk = new char[n];
        for (char c : s.toCharArray()) {
            char p = idx == 0 ? ' ' : sk[idx - 1];
            if ((p == 'A' && c == 'B') || (p == 'C' && c == 'D')) idx--;
            else sk[idx++] = c;
        }
        return idx;
    }
}
