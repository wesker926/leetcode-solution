package com.wesker926.leetcode.algorithms.p0135.s1;

/**
 * @author wesker.gh
 * @date 2022/5/21
 * @description 贪心
 * 本质上是找单调区间后计算，很丑陋但能过
 */
public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] diff = new int[ratings.length - 1];
        for (int i = 0; i < ratings.length - 1; i++) {
            diff[i] = Integer.compare(ratings[i + 1], ratings[i]);
        }
        int sum = 0, lastMax = 0;
        for (int i = 0, j = 1; j <= diff.length; j++) {
            if (j == diff.length || diff[i] != diff[j]) {
                if (diff[i] == 0) {
                    if (i != 0 && diff[i - 1] > 0) {
                        sum += lastMax;
                    }
                } else if (diff[i] > 0) {
                    sum += (j - i - 1) * (j - i) / 2;
                    lastMax = j - i;
                } else {
                    sum += (j - i + 1) * (j - i) / 2;
                    if (i != 0 && diff[i - 1] > 0 && lastMax > j - i) {
                        sum += lastMax - (j - i);
                    }
                }
                i = j;
            }
        }
        return sum + ratings.length + (diff[diff.length - 1] > 0 ? lastMax : 0);
    }
}
