package com.wesker926.leetcode.algorithms.p0822.s1;

/**
 * @author wesker.gh
 * @date 2023/8/2
 * @description 哈希表
 */
public class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int ans = 2001;
        boolean[] table = new boolean[ans];
        for (int i = 0; i < fronts.length; i++)
            if (fronts[i] == backs[i]) table[fronts[i]] = true;
        for (int i = 0; i < fronts.length; i++) {
            if (!table[fronts[i]]) ans = Math.min(ans, fronts[i]);
            if (!table[backs[i]]) ans = Math.min(ans, backs[i]);
        }
        return ans == 2001 ? 0 : ans;
    }
}
