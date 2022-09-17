package com.wesker926.leetcode.algorithms.p1624.s1;

/**
 * @author wesker.gh
 * @date 2022/9/17
 * @description 遍历
 */
public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (table[c] == 0) {
                table[c] = i + 1;
            } else {
                ans = Math.max(ans, i - table[c]);
            }
        }
        return ans;
    }
}
