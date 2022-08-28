package com.wesker926.leetcode.algorithms.p0793.s1;

/**
 * @author wesker.gh
 * @date 2022/8/28
 * @description 二分 + 数学
 * 注：答案非5即0，因此只要找到zeta(m)=k则必为5，否则必为0，因此可以只用一次二分
 */
public class Solution {
    public int preimageSizeFZF(int k) {
        return (int) (binary(k + 1) - binary(k));
    }

    private long binary(int k) {
        long l = 0, r = k * 5L, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (zeta(m) < k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private long zeta(long n) {
        long res = 0;
        while (n != 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
