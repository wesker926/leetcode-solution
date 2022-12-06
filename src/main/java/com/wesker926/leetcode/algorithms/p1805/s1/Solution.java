package com.wesker926.leetcode.algorithms.p1805.s1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2022/12/6
 * @description 双指针
 */
public class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0, j = 0; j <= word.length(); j++) {
            if (j < word.length() && Character.isDigit(word.charAt(j))) {
                continue;
            }
            if (j != i) {
                for (; i < j - 1 && word.charAt(i) == '0'; i++) {
                }
                set.add(word.substring(i, j));
            }
            i = j + 1;
        }
        return set.size();
    }
}
