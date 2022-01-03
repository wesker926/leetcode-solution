package com.wesker926.leetcode.algorithms.p1185.s1;

/**
 * @author wesker.gh
 * @date 2022/1/3
 * @description 模拟
 */
public class Solution {

    private static final int START_WEEK_DAY = 5;

    private static final int[] MONTH_DAY = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final String[] WEEK_NAME = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        // 1971 ~ 2100
        day += (year - 1971) * 365 + (year - 1969) / 4;
//        for (int i = 1971; i < year; i++) {
//            day += isLeapYear(i) ? 366 : 365;
//        }
        if (month > 2 && isLeapYear(year)) {
            day++;
        }
        for (int i = 0; i < month - 1; i++) {
            day += MONTH_DAY[i];
        }
        return WEEK_NAME[(day - 1 + START_WEEK_DAY) % 7];
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }

        if (year % 100 == 0) {
            return false;
        }

        return year % 4 == 0;
    }
}
