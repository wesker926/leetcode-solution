package com.wesker926.leetcode.algorithms.p1814.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/1/17
 * @description 哈希
 * 思想跟两数之和很相像
 * 把相同变量转移到等式同一边的变形至关重要
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = num - reverse(num);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        long ans = 0;
        for (long value : map.values()) {
            ans = (ans + value * (value - 1) / 2) % MOD;
        }
        return (int) ans;
    }

    private int reverse(int a) {
        int b = 0;
        for (; a != 0; a /= 10) {
            b = b * 10 + (a % 10);
        }
        return b;
    }
}
