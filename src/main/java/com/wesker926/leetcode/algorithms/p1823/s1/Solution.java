package com.wesker926.leetcode.algorithms.p1823.s1;

/**
 * @author wesker.gh
 * @date 2022/5/4
 * @description DP（同lcof-p062）
 * 约瑟夫环
 */
public class Solution {
    public int findTheWinner(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        return ans + 1;
    }
}
