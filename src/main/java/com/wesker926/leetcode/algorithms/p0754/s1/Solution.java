package com.wesker926.leetcode.algorithms.p0754.s1;

/**
 * @author wesker.gh
 * @date 2022/11/4
 * @description 数学分析
 * 找到k使sum(1~k)大于等于t
 * 若diff=sum-t值为偶数，则必可以找到数字取反，使sum=t
 * 若diff为奇数，则再走至多两步也可达成sum=t，k为偶数则多走一步，k为奇数则多走两步
 */
public class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = (int) Math.ceil((-1 + Math.sqrt(1 + 8 * (long) target)) / 2);
        target -= k * (k + 1) / 2;
        return (target & 1) == 0 ? k : k + 1 + (k & 1);
    }
}
