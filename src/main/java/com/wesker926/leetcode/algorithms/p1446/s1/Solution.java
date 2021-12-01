package com.wesker926.leetcode.algorithms.p1446.s1;

/**
 * @author wesker.gh
 * @date 2021/12/1
 * @description 遍历
 */
public class Solution {
    public int maxPower(String s) {
        int max = 1, cur = 1;
        char[] cs = s.toCharArray();
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == cs[i - 1]) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 1;
            }
        }
        return Math.max(max, cur);
    }
}
