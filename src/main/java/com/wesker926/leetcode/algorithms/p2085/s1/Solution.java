package com.wesker926.leetcode.algorithms.p2085.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2024/1/12
 * @description 哈希表
 */
public class Solution {
    public int countWords(String[] words1, String[] words2) {
        int res = 0;
        Map<String, Integer> stat = new HashMap<>();
        for (String word : words1) stat.put(word, stat.getOrDefault(word, 0) + 1);
        for (String word : words2) stat.put(word, stat.getOrDefault(word, 0) + 10000);
        for (Integer val : stat.values()) if (val == 10001) res++;
        return res;
    }
}
