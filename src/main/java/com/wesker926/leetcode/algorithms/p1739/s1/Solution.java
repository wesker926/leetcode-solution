package com.wesker926.leetcode.algorithms.p1739.s1;

/**
 * @author wesker.gh
 * @date 2022/12/25
 * @description 二分 + 累加和
 * n项和公式（三角形数）：n * (n + 1) / 2
 * 三角堆和公式（四面体数）：n * (n + 1) * (n + 2) / 6
 * 三角堆和是n项和的和，因此是n * (n + 1) / 2的累加，即(n平方累加 + n累加) / 2
 * 其中，n平方和为 n * (n + 1) * (2n + 1) / 6
 * 注：本题可通过不等式计算省去二分
 */
public class Solution {
    public int minimumBoxes(int n) {
        int order = binary(n, true);
        return (int) accumulate2(order - 1) + binary(n - (int) accumulate3(order - 1), false);
    }

    private int binary(int t, boolean model3) {
        int l = 0, r = 2000, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            long v = model3 ? accumulate3(m) : accumulate2(m);
            if (v < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private long accumulate2(long n) {
        return n * (n + 1) / 2;
    }

    private long accumulate3(long n) {
        return n * (n + 1) * (n + 2) / 6;
    }
}
