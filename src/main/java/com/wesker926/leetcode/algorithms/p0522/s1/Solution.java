package com.wesker926.leetcode.algorithms.p0522.s1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2022/6/27
 * @description 哈希表
 * O(m*2^n)
 */
public class Solution {
    public int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            Set<String> set = new HashSet<>();
            dfs(str.toCharArray(), 0, new StringBuilder(), set);
            for (String s : set) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int max = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                max = Math.max(max, entry.getKey().length());
            }
        }
        return max;
    }

    private void dfs(char[] cs, int idx, StringBuilder sb, Set<String> set) {
        if (idx == cs.length) {
            set.add(sb.toString());
            return;
        }
        dfs(cs, idx + 1, sb, set);
        sb.append(cs[idx]);
        dfs(cs, idx + 1, sb, set);
        sb.deleteCharAt(sb.length() - 1);
    }
}
