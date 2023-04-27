package com.wesker926.leetcode.algorithms.p1048.s1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/4/27
 * @description DP
 * 排序（落桶） + DP
 */
public class Solution {
    @SuppressWarnings("all")
    public int longestStrChain(String[] words) {
        List[] table = new List[16];
        for (int i = 0; i < table.length; i++) {
            table[i] = new ArrayList<String>();
        }
        for (String word : words) {
            table[word.length() - 1].add(word);
        }
        int ans = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < table.length; i++) {
            for (String word : (List<String>) table[i]) {
                int cur = 1;
                for (int j = 0; j < word.length(); j++) {
                    cur = Math.max(cur, map.getOrDefault(
                            word.substring(0, j) + word.substring(j + 1), 0) + 1);
                }
                map.put(word, cur);
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
}
