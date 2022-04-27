package com.wesker926.leetcode.algorithms.p0030.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/4/27
 * @description 哈希表 + 滑动窗口
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new LinkedList<>();
        int strLen = s.length(), wordCount = words.length, wordLen = words[0].length();
        if (strLen < wordCount * wordLen) {
            return ans;
        }

        char[] scs = s.toCharArray();
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (int st = 0; st < wordLen; st++) {
            int findCount = 0;
            Map<String, Integer> tempMap = new HashMap<>();
            for (int i = st, j = st; j + wordLen <= strLen; j += wordLen) {
                String word = new String(scs, j, wordLen);
                if (tempMap.getOrDefault(word, 0) >= wordCountMap.getOrDefault(word, 0)) {
                    for (; i < j; i += wordLen) {
                        String remove = new String(scs, i, wordLen);
                        if (remove.equals(word)) {
                            break;
                        }
                        findCount--;
                        tempMap.put(remove, tempMap.get(remove) - 1);
                    }
                    i += wordLen;
                } else {
                    findCount++;
                    tempMap.put(word, tempMap.getOrDefault(word, 0) + 1);
                }
                if (findCount == wordCount) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}
