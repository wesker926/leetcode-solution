package com.wesker926.leetcode.algorithms.p0299.s1;

/**
 * @author wesker.gh
 * @date 2021/11/8
 * @description 哈希表
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int[] set = new int[10];
        int match = 0, same = 0;
        char[] a = secret.toCharArray(), b = guess.toCharArray();
        for (int i = 0; i < a.length; i++) {
            set[a[i] - '0']++;
            if (a[i] == b[i]) {
                match++;
            }
        }
        for (char c : b) {
            if (set[c - '0'] > 0) {
                set[c - '0']--;
                same++;
            }
        }
        same -= match;
        return new StringBuilder().append(match).append('A').append(same).append('B').toString();
    }
}
