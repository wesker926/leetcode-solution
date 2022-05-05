package com.wesker926.leetcode.algorithms.p0077.s1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/5
 * @description 回溯
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return backTracking(new LinkedList<>(), new LinkedList<>(), n, k);
    }

    private List<List<Integer>> backTracking(List<List<Integer>> ans, LinkedList<Integer> cur, int n, int k) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return ans;
        }

        for (int i = cur.size() == 0 ? 1 : cur.getLast() + 1; i <= n - (k - cur.size()) + 1; i++) {
            cur.add(i);
            backTracking(ans, cur, n, k);
            cur.removeLast();
        }
        return ans;
    }
}
