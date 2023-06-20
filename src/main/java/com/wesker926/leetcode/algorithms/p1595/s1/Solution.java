package com.wesker926.leetcode.algorithms.p1595.s1;

import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/6/20
 * @description DP
 * https://leetcode.cn/problems/minimum-cost-to-connect-two-groups-of-points/solutions/2311504/lian-tong-liang-zu-dian-de-zui-xiao-chen-6qoj/
 */
public class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int m = cost.size(), total = 1 << cost.get(0).size();
        int[][] dp = new int[2][total];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;
        for (List<Integer> edge : cost) {
            Arrays.fill(dp[1], Integer.MAX_VALUE);
            for (int j = 0; j < 2; j++) {
                for (int cur = 0; cur < total; cur++) {
                    if (dp[j][cur] == Integer.MAX_VALUE) continue;
                    for (int k = 0; k < edge.size(); k++) {
                        int nxt = cur | (1 << k);
                        dp[1][nxt] = Math.min(dp[1][nxt], dp[j][cur] + edge.get(k));
                    }
                }
            }
            int[] temp = dp[0];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[m][total - 1];
    }
}
