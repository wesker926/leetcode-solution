package com.wesker926.leetcode.algorithms.p1189.s1;

/**
 * @author wesker.gh
 * @date 2022/2/13
 * @description 遍历统计
 */
public class Solution {

    private static final char[] NEED = new char[]{'b', 'a', 'l', 'o', 'n'};

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        count[11] >>= 1;
        count[14] >>= 1;
        int ans = Integer.MAX_VALUE;
        for (char c : NEED) {
            ans = Math.min(ans, count[c - 'a']);
        }
        return ans;
    }
}
