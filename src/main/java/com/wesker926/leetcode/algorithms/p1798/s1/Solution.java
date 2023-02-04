package com.wesker926.leetcode.algorithms.p1798.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/2/4
 * @description 贪心
 * 要求构造从0开始的最长的连续数字。
 * 先排序数组，假设当前可以构造到[0, x]，如果下一个数字y <= x + 1,那么就可以构造[0,x+y]。
 * 否则，能构造到序列就不连续了，直接退出。
 */
public class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > res) {
                break;
            }
            res += coin;
        }
        return res;
    }
}
