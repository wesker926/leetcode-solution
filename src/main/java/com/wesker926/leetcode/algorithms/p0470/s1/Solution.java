package com.wesker926.leetcode.algorithms.p0470.s1;

/**
 * @author wesker.gh
 * @date 2021/12/18
 * @description 拒绝采样
 */
public class Solution {

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    public int rand10() {
        int x, y, ans;
        do {
            x = rand7();
            y = rand7();
            ans = (x - 1) * 7 + y;
        } while (ans > 40);
        return ((ans - 1) % 10) + 1;
    }

    private int rand7() {
        return 0;
    }
}
