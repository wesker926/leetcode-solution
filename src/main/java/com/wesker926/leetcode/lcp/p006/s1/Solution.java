package com.wesker926.leetcode.lcp.p006.s1;

/**
 * @author wesker.gh
 * @date 2023/9/20
 * @description 遍历
 * 除以2向上取整
 */
public class Solution {
    public int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) ans += (coin + 1) >> 1;
        return ans;
    }
}
