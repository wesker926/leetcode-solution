package com.wesker926.leetcode.algorithms.p0022.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/25
 * @description 回溯
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        return dfs(new LinkedList<>(), new char[n * 2], 0, n, n);
    }

    private List<String> dfs(List<String> ans, char[] cur, int idx, int l, int r) {
        if (idx == cur.length) {
            ans.add(new String(cur));
            return ans;
        }
        if (l > 0) {
            cur[idx] = '(';
            ans = dfs(ans, cur, idx + 1, l - 1, r);
        }
        if (r > l) {
            cur[idx] = ')';
            ans = dfs(ans, cur, idx + 1, l, r - 1);
        }
        return ans;
    }
}
