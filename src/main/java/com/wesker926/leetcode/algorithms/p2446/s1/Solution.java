package com.wesker926.leetcode.algorithms.p2446.s1;

/**
 * @author wesker.gh
 * @date 2023/5/17
 * @description 格式化
 */
public class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int st1 = getTime(event1[0]), ed1 = getTime(event1[1]);
        int st2 = getTime(event2[0]), ed2 = getTime(event2[1]);
        return st1 <= ed2 && st2 <= ed1;
    }

    private int getTime(String time) {
        char[] cs = time.toCharArray();
        return (cs[0] - '0') * 600 + (cs[1] - '0') * 60 + (cs[3] - '0') * 10 + (cs[4] - '0');
    }
}
