package com.wesker926.leetcode.algorithms.p1663.s1;

/**
 * @author wesker.gh
 * @date 2023/1/26
 * @description 贪心
 * 不妨先铺满a，然后把剩余的数右对齐分配进去
 * 所以最终通式是前面a后面z，中间夹一个字母
 */
public class Solution {
    public String getSmallestString(int n, int k) {
        int count = (k - n) / 25;
        return count == n ? "z".repeat(n) : "a".repeat(n - count - 1) + (char) ('a' + ((k - n) % 25)) + "z".repeat(count);
    }
}
