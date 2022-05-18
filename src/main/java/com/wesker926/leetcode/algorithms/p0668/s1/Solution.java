package com.wesker926.leetcode.algorithms.p0668.s1;

/**
 * @author wesker.gh
 * @date 2022/5/18
 * @description 二分
 * 规模大无法遍历 -> 转化为二分猜数字
 * 注意，因为x统计的count为不大于自身的count，因此如果x不在表中，必然存在一个表中数小于x且count相同。
 * 因此，满足一个count的最小数字必然在表中。
 * 我们统计left左为count小于k的，因此left必然为count等于k的最小数字，也必然在表中。
 */
public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n, x;
        while (l <= r) {
            x = l + (r - l) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; i++) {
                count += x / i;
            }
            if (count < k) {
                l = x + 1;
            } else {
                r = x - 1;
            }
        }
        return l;
    }
}
