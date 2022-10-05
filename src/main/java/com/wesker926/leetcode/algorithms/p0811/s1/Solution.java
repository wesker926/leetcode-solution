package com.wesker926.leetcode.algorithms.p0811.s1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wesker.gh
 * @date 2022/10/5
 * @description 哈希表
 */
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int stop = 0;
            for (; cpdomain.charAt(stop) != ' '; stop++) {
            }
            int count = Integer.parseInt(cpdomain.substring(0, stop));
            for (int i = cpdomain.length() - 1; i >= stop; i--) {
                if (cpdomain.charAt(i) == '.' || cpdomain.charAt(i) == ' ') {
                    String key = cpdomain.substring(i + 1);
                    counts.put(key, counts.getOrDefault(key, 0) + count);
                }
            }
        }
        return counts.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey()).collect(Collectors.toList());
    }
}
