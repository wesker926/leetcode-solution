package com.wesker926.leetcode.lcof.p046.s1;

/**
 * @author wesker.gh
 * @date 2022/4/15
 * @description DFS
 */
public class Solution {
    public int translateNum(int num) {
        return dfs(String.valueOf(num).toCharArray(), 0);
    }

    private int dfs(char[] num, int idx) {
        return idx == num.length ? 1 : (dfs(num, idx + 1) + (idx != num.length - 1 && ((num[idx] == '1') || (num[idx] == '2' && num[idx + 1] < '6')) ? dfs(num, idx + 2) : 0));
    }
}
