package com.wesker926.leetcode.algorithms.p1641.s2;

/**
 * @author wesker.gh
 * @date 2023/3/29
 * @description 数学
 * 组合数：
 * 对于一个按字典序排列的元音字符串，假设a，e，i，o，u的起始下标分别为i1,i2,i3,i4,i5
 * 那么显然 0 = i1 <= i2 <= i3 <= i4 <= i5 <= n
 * 设 j1 = 0，j2 = i2，j3 = i3 + 1，j4 = i4 + 2，j5 = i5 + 3
 * 则 0 = j1 <= j2 < j3 < j4 < j5 <= n + 3
 * 则原问题等价于求解C(4)(n+4)
 */
public class Solution {
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
}
