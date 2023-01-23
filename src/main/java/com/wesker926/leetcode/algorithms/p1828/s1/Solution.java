package com.wesker926.leetcode.algorithms.p1828.s1;

/**
 * @author wesker.gh
 * @date 2023/1/24
 * @description 枚举
 * 貌似有二分的优化方法？
 */
public class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int r2 = query[2] * query[2];
            for (int[] point : points) {
                int x = point[0] - query[0], y = point[1] - query[1];
                if (x * x + y * y <= r2) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
