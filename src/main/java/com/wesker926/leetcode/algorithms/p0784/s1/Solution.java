package com.wesker926.leetcode.algorithms.p0784.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/10/30
 * @description DFS
 * 大小写转换可以用c ^ 32来做
 */
public class Solution {
    public List<String> letterCasePermutation(String s) {
        return dfs(s.toCharArray(), 0, new LinkedList<>());
    }

    private List<String> dfs(char[] cs, int idx, List<String> res) {
        if (idx == cs.length) {
            res.add(new String(cs));
            return res;
        }
        if (!Character.isLetter(cs[idx])) {
            return dfs(cs, idx + 1, res);
        }
        cs[idx] = Character.toLowerCase(cs[idx]);
        dfs(cs, idx + 1, res);
        cs[idx] = Character.toUpperCase(cs[idx]);
        return dfs(cs, idx + 1, res);
    }
}
