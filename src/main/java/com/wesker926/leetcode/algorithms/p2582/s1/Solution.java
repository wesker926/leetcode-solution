package com.wesker926.leetcode.algorithms.p2582.s1;

/**
 * @author wesker.gh
 * @date 2023/9/26
 * @description 模拟
 */
public class Solution {
    public int passThePillow(int n, int time) {
        int mod = time % (n - 1);
        return ((time / (n - 1)) & 1) == 0 ? mod + 1 : n - mod;
    }
}
