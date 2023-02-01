package com.wesker926.leetcode.algorithms.p2325.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/2/1
 * @description 模拟
 */
public class Solution {
    public String decodeMessage(String key, String message) {
        int[] table = new int[26];
        Arrays.fill(table, -1);
        for (int i = 0, j = 0; i < key.length() && j < 26; i++) {
            char ch = key.charAt(i);
            if (ch != ' ' && table[ch - 'a'] == -1) {
                table[ch - 'a'] = j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            sb.append(ch == ' ' ? ch : (char) (table[ch - 'a'] + 'a'));
        }
        return sb.toString();
    }
}
