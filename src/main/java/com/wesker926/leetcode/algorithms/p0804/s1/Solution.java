package com.wesker926.leetcode.algorithms.p0804.s1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2022/4/10
 * @description 哈希表 + 二进制优化
 */
public class Solution {

    private static final String[] CODE = new String[]{
            ".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set<Integer> set = new HashSet<>();
        for (String word : words) {
            int t = 1;
            for (char c1 : word.toCharArray()) {
                for (char c2 : CODE[c1 - 'a'].toCharArray()) {
                    t = (t << 1) | (c2 == '.' ? 0 : 1);
                }
            }
            set.add(t);
        }
        return set.size();
    }
}
