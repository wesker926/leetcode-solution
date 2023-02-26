package com.wesker926.leetcode.algorithms.p1255.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/2/26
 * @description 状态压缩
 * 尼玛的麻瓜牛马题
 */
public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int max = 0;
        int[] has = new int[26], need = new int[26];
        for (char letter : letters) {
            has[letter - 'a']++;
        }
        outer:
        for (int s = 0; s < (1 << words.length); s++) {
            Arrays.fill(need, 0);
            for (int i = 0, j = s; j != 0; j >>= 1, i++) {
                if ((j & 1) == 0) {
                    continue;
                }
                for (int k = 0; k < words[i].length(); k++) {
                    need[words[i].charAt(k) - 'a']++;
                }
            }
            int cur = 0;
            for (int i = 0; i < has.length; i++) {
                if (has[i] < need[i]) {
                    continue outer;
                }
                cur += need[i] * score[i];
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
