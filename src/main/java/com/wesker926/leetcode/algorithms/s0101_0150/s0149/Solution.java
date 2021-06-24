package com.wesker926.leetcode.algorithms.s0101_0150.s0149;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2021/6/24
 * @description 149. 直线上最多的点数
 */
public class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int max = 0, x, y, gcd, key;
        Map<Integer, Integer> map;
        for (int i = 0; i < n; i++) {
            if (max > n / 2 || max >= n - i) {
                return max;
            }
            map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                x = points[i][0] - points[j][0];
                y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    gcd = gcd(Math.abs(x), Math.abs(y));
                    x /= gcd;
                    y /= gcd;
                }
                key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Integer v : map.values()) {
                max = Math.max(max, v + 1);
            }
        }
        return max;
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
