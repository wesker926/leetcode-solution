package com.wesker926.leetcode.algorithms.p2437.s1;

/**
 * @author wesker.gh
 * @date 2023/5/9
 * @description 分类讨论
 */
public class Solution {
    public int countTime(String time) {
        char[] cs = time.toCharArray();
        int ans = (cs[3] == '?' ? 6 : 1) * (cs[4] == '?' ? 10 : 1);
        if (cs[0] == '?' && cs[1] == '?') ans *= 24;
        else if (cs[0] == '?') ans *= cs[1] < '4' ? 3 : 2;
        else if (cs[1] == '?') ans *= cs[0] == '2' ? 4 : 10;
        return ans;
    }
}
