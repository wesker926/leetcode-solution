package com.wesker926.leetcode.algorithms.p1807.s1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/1/12
 * @description 哈希表 + 双指针
 */
public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> kv : knowledge) {
            map.put(kv.get(0), kv.get(1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; j <= s.length(); j++) {
            if (j < s.length() && s.charAt(j) != '(') {
                continue;
            }
            sb.append(s, i, j);
            if (j < s.length()) {
                for (i = j + 1; s.charAt(j) != ')'; j++) ;
                sb.append(map.getOrDefault(s.substring(i, j), "?"));
                i = j + 1;
            }
        }
        return sb.toString();
    }
}
