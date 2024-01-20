package com.wesker926.leetcode.algorithms.p2788.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2024/1/20
 * @description 双指针
 */
public class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new LinkedList<>();
        for (String word : words) {
            for (int i = 0, j = 0, n = word.length(); j <= n; j++) {
                if (j != n && word.charAt(j) != separator) continue;
                if (j > i) res.add(word.substring(i, j));
                i = j + 1;
            }
        }
        return res;
    }
}
