package com.wesker926.leetcode.algorithms.p2423.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/4/29
 * @description 枚举 + 哈希
 * 可能是最难的easy题
 */
public class Solution {
    public boolean equalFrequency(String word) {
        int[] table = new int[26];
        for (int i = 0; i < word.length(); i++) table[word.charAt(i) - 'a']++;
        Map<Integer, Integer> map = new HashMap<>();
        for (int freq : table) {
            if (freq == 0) continue;
            map.put(freq, map.getOrDefault(freq, 0) + 1);
            if (map.size() > 2) return false;
        }
        int idx = 0;
        int[] stat = new int[4];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            stat[idx + 2] = entry.getValue();
            stat[idx++] = entry.getKey();
        }
        if (stat[1] == 0) return stat[2] == 1 || stat[0] == 1;
        return (stat[2] == 1 && (stat[0] == 1 || (stat[0] - stat[1] == 1))) ||
                (stat[3] == 1 && (stat[1] == 1 || stat[1] - stat[0] == 1));
    }

    public boolean equalFrequency1(String word) {
        int[] table = new int[26];
        for (int i = 0; i < word.length(); i++) table[word.charAt(i) - 'a']++;
        int[] stat = new int[4];
        for (int count : table) {
            if (count == 0) continue;
            if (count == stat[0]) {
                stat[2]++;
                continue;
            }
            if (count == stat[1]) {
                stat[3]++;
                continue;
            }
            if (stat[1] != 0) return false;
            stat[1] = stat[0];
            stat[3] = stat[2];
            stat[0] = count;
            stat[2] = 1;
        }
        if (stat[1] == 0) return stat[2] == 1 || stat[0] == 1;
        return (stat[2] == 1 && (stat[0] == 1 || (stat[0] - stat[1] == 1))) ||
                (stat[3] == 1 && (stat[1] == 1 || stat[1] - stat[0] == 1));
    }
}
