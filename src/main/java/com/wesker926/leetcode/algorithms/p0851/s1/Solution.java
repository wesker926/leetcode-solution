package com.wesker926.leetcode.algorithms.p0851.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2021/12/15
 * @description 构造图 + dfs
 */
public class Solution {

    private int[] quiet;

    private int[] ans;

    private List[] relation;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        relation = new List[n];
        for (int i = 0; i < n; i++) {
            relation[i] = new LinkedList<Integer>();
        }
        for (int[] ints : richer) {
            relation[ints[1]].add(ints[0]);
        }

        this.quiet = quiet;
        ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        return ans;
    }

    private void dfs(int i) {
        if (ans[i] != -1) {
            return;
        }

        ans[i] = i;
        for (Object o : relation[i]) {
            int j = (int) (o);
            dfs(j);
            if (quiet[ans[i]] > quiet[ans[j]]) {
                ans[i] = ans[j];
            }
        }
    }
}
