package com.wesker926.leetcode.algorithms.p0860.s1;

/**
 * @author wesker.gh
 * @date 2023/7/22
 * @description 贪心
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {
                if (--five < 0) return false;
                ten++;
            } else if (ten > 0 && five > 0) {
                ten--;
                five--;
            } else if ((five -= 3) < 0) return false;
        }
        return true;
    }
}
