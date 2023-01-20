package com.wesker926.leetcode.algorithms.p1817.s1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2023/1/20
 * @description 哈希表
 */
public class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> maps = new HashMap<>();
        for (int[] log : logs) {
            maps.computeIfAbsent(log[0], k1 -> new HashSet<>()).add(log[1]);
        }
        int[] ans = new int[k];
        for (Set<Integer> set : maps.values()) {
            ans[set.size() - 1]++;
        }
        return ans;
    }
}
