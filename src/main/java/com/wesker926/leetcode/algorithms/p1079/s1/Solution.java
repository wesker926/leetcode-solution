package com.wesker926.leetcode.algorithms.p1079.s1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2023/5/19
 * @description 回溯
 */
public class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        dfs(tiles.toCharArray(), 0, set);
        return set.size();
    }

    private void dfs(char[] cs, int idx, Set<String> set) {
        if (idx == cs.length) return;
        for (int i = idx; i < cs.length; i++) {
            swap(cs, idx, i);
            if (set.add(new String(cs, 0, idx + 1))) {
                dfs(cs, idx + 1, set);
            }
            swap(cs, idx, i);
        }
    }

    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }
}
