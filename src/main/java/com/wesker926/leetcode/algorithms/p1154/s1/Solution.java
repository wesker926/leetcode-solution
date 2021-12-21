package com.wesker926.leetcode.algorithms.p1154.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2021/12/21
 * @description 计算闰年
 */
public class Solution {

    private static final int[] DAYS = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        int[] nums = Arrays.stream(date.split("-")).mapToInt(Integer::parseInt).toArray();

        int ans = nums[2];
        if (nums[1] > 2 && isLeapYear(nums[0])) {
            ans++;
        }

        for (int i = 0; i < nums[1] - 1; i++) {
            ans += DAYS[i];
        }
        return ans;
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
