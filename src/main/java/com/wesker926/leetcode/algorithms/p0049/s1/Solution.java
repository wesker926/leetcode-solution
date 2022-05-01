package com.wesker926.leetcode.algorithms.p0049.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description 排序 + 哈希表
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            map.computeIfAbsent(new String(cs), key -> new LinkedList<>()).add(str);
        }
        return new LinkedList<>(map.values());
    }
}
