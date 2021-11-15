package com.wesker926.leetcode.algorithms.p0319.s1;

/**
 * @author wesker.gh
 * @date 2021/11/15
 * @description 只有平方数会亮
 */
public class Solution {
    public int bulbSwitch(int n) {
        // 加0.5为了避免精度问题
        return (int) Math.sqrt(n + 0.5);
    }
}
