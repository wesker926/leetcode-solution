package com.wesker926.leetcode.algorithms.p0470.s2;

/**
 * @author wesker.gh
 * @date 2021/12/18
 * @description 拒绝采样 - 调用次数期望优化
 */
public class Solution {
    public int rand10() {
        int x, y, ans;
        for (; ; ) {
            x = rand7();
            y = rand7();
            ans = (x - 1) * 7 + y;
            if (ans <= 40) {
                return ((ans - 1) % 10) + 1;
            }

            x = ans - 41;
            y = rand7();
            ans = x * 7 + y;
            if (ans <= 60) {
                return ((ans - 1) % 10) + 1;
            }

            x = ans - 61;
            y = rand7();
            ans = x * 7 + y;
            if (ans <= 20) {
                return ((ans - 1) % 10) + 1;
            }
        }
    }

    private int rand7() {
        return 0;
    }
}
