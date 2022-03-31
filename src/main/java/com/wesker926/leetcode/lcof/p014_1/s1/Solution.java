package com.wesker926.leetcode.lcof.p014_1.s1;

/**
 * @author wesker.gh
 * @date 2022/3/31
 * @description 贪心 注：尽量多的3，但当模1时把31替换为22
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        int mod = n % 3, count3 = n / 3;
        if (mod == 1) {
            mod = 4;
            count3--;
        }
        return (int) Math.pow(3, count3) * (mod == 0 ? 1 : mod);
    }
}
