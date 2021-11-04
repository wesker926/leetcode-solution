package com.wesker926.leetcode.algorithms.p0367.s2;

/**
 * @author wesker.gh
 * @date 2021/11/4
 * @description 牛顿迭代法
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        double cur = (double) num, nxt = 0;
        while (true) {
            nxt = (cur + (double) num / cur) / 2;
            if (cur - nxt < 1e-6) {
                break;
            }
            cur = nxt;
        }
        return (int) nxt * (int) nxt == num;
    }
}
