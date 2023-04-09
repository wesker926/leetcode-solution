package com.wesker926.leetcode.algorithms.p2399.s1;

/**
 * @author wesker.gh
 * @date 2023/4/9
 * @description 遍历
 */
public class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] first = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == 0) {
                first[ch] = i + 1;
                continue;
            }
            if (i - first[ch] != distance[ch]) {
                return false;
            }
        }
        return true;
    }
}
