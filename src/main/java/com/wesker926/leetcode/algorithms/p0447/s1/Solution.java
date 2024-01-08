package com.wesker926.leetcode.algorithms.p0447.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2024/1/8
 * @description 哈希表
 * 没什么捷径方法
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] p1 : points) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] p2 : points) {
                int len = (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
                cnt.put(len, cnt.getOrDefault(len, 0) + 1);
            }
            for (int c : cnt.values()) {
                if (c > 1) res += c * (c - 1);
            }
        }
        return res;
    }
}
