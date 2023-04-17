package com.wesker926.leetcode.algorithms.p2409.s1;

/**
 * @author wesker.gh
 * @date 2023/4/17
 * @description 转化
 * 将日期字符串转化为一年中的天数
 */
public class Solution {

    private static final int[] PRE = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aSt = convert(arriveAlice), aEd = convert(leaveAlice), bSt = convert(arriveBob), bEd = convert(leaveBob);
        return Math.max(Math.min(aEd, bEd) - Math.max(aSt, bSt) + 1, 0);
    }

    private int convert(String date) {
        return PRE[Integer.parseInt(date, 0, 2, 10) - 1] + Integer.parseInt(date, 3, 5, 10);
    }
}
