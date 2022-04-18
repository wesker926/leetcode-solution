package com.wesker926.leetcode.algorithms.p0386.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/18
 * @description 递归DFS O(n) / O(n)
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        return dfs(new LinkedList<>(), 1, n);
    }

    private List<Integer> dfs(List<Integer> ans, int c, int n) {
        for (int k = c % 10; k < 10 && c <= n; k++, c++) {
            ans.add(c);
            dfs(ans, c * 10, n);
        }
        return ans;
    }
}
