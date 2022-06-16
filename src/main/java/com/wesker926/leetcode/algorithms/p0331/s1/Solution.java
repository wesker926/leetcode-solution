package com.wesker926.leetcode.algorithms.p0331.s1;

/**
 * @author wesker.gh
 * @date 2022/6/16
 * @description DFS
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] sp = preorder.split(",");
        return dfs(sp, 0) == sp.length;
    }

    private int dfs(String[] sp, int idx) {
        return idx >= sp.length || "#".equals(sp[idx]) ? idx + 1 : dfs(sp, dfs(sp, idx + 1));
    }
}
