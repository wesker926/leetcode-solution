package com.wesker926.leetcode.algorithms.p0013.s1;

/**
 * @author wesker.gh
 * @date 2022/4/22
 * @description 模拟
 */
public class Solution {

    private static final int[] MAP = new int[]{0, 0, 100, 500, 0, 0, 0, 0, 1, 0, 0, 50, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10, 0, 0};

    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int ans = MAP[cs[0] - 'A'];
        for (int i = 1, cur, pre; i < cs.length; i++) {
            cur = MAP[cs[i] - 'A'];
            pre = MAP[cs[i - 1] - 'A'];
            ans += cur;
            if (cur > pre) {
                ans -= pre * 2;
            }
        }
        return ans;
    }
}