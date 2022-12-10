package com.wesker926.leetcode.algorithms.p1691.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/12/10
 * @description DP
 * 可以证明：
 * 1.若存在可以堆叠的两个长方体，则它们必然满足长宽高排序并从小到大对应后也可以堆叠，即：
 * 若[l1, w1, h1] 可以堆叠于[l2, w2, h2]之上，则[l1', w1', h1']也可以堆叠于[l2', w2', h2']之上，其中后者是前者排序后的序列
 * 2.直接把长宽高中最大者当高度来计算是正确的
 * 因为若不以最大者当高度的话，要么是可以放置但本层结果更差，且后续结果不会更好（仍然有相同甚至更差的约束）；要么本来就无法放置（怎么放都不满足约束）
 * 3.DP计算时，dp[i]需要任何可以被放置在其上的dp[j]都已计算完成，可以通过排序来实现
 * 只需保持长宽高均不大于方块B的方块A更靠前即可，可以有多种排序方法，求和最方便
 */
public class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, (c1, c2) -> c1[0] + c1[1] + c1[2] - c2[0] - c2[1] - c2[2]);
        int n = cuboids.length, ans = 0;
        int[] dp = new int[n];
        for (int i = 0, j; i < n; i++) {
            for (j = 0, dp[i] = cuboids[i][2]; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
