package com.wesker926.leetcode.algorithms.p1657.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/11/30
 * @description 计数
 */
public class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] t1 = new int[26], t2 = new int[26];
        for (char c : word1.toCharArray()) t1[c - 'a']++;
        for (char c : word2.toCharArray()) t2[c - 'a']++;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (t1[i] == 0 && t2[i] == 0) continue;
            if (t1[i] == 0 || t2[i] == 0) return false;
            m.put(t1[i], m.getOrDefault(t1[i], 0) + 1);
            m.put(t2[i], m.getOrDefault(t2[i], 0) - 1);
        }
        for (int v : m.values()) if (v != 0) return false;
        return true;
    }
}
