package com.wesker926.leetcode.algorithms.p0819.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/4/17
 * @description 哈希表
 */
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        char[] cs = paragraph.toCharArray();
        Map<String, Integer> countMap = new HashMap<>();
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));
        String ans = null;
        int maxCount = 0;
        for (int i = 0, j = 0; j <= cs.length; j++) {
            if (j == cs.length || !Character.isLetter(cs[j])) {
                if (j - i > 0) {
                    String word = new String(cs, i, j - i).toLowerCase();
                    if (!banSet.contains(word)) {
                        int count = countMap.getOrDefault(word, 0) + 1;
                        if (count > maxCount) {
                            maxCount = count;
                            ans = word;
                        }
                        countMap.put(word, count);
                    }
                }
                i = j + 1;
            }
        }
        return ans;
    }
}
