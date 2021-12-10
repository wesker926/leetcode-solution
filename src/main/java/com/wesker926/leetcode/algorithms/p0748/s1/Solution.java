package com.wesker926.leetcode.algorithms.p0748.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2021/12/10
 * @description 字母表 + 遍历
 */
public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] o = new int[26];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                o[c - 'a']++;
            }
        }

        int[] t = new int[26];
        int idx = 0, min = 16;
        loop1:
        for (int i = 0; i < words.length; i++) {
            Arrays.fill(t, 0);
            for (char c : words[i].toCharArray()) {
                t[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if (t[j] < o[j]) {
                    continue loop1;
                }
            }

            if (words[i].length() < min) {
                idx = i;
                min = words[i].length();
            }
        }

        return words[idx];
    }
}
