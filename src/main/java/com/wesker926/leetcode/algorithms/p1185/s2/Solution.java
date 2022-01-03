package com.wesker926.leetcode.algorithms.p1185.s2;

/**
 * @author wesker.gh
 * @date 2022/1/3
 * @description 蔡勒公式
 * D = c / 4 - c * 2 + y + y / 4 + (m + 1) * 13 / 5 + d - 1
 * W = D % 7
 */
public class Solution {

    private static final String[] WEEK_NAME = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        if (month < 3) {
            month = month + 12;
            year--;
        }
        int c = year / 100, y = year % 100;
        int D = c / 4 - c * 2 + y + y / 4 + (month + 1) * 13 / 5 + day - 1 + 30 * 7;
        return WEEK_NAME[D % 7];
    }
}
