package com.wesker926.leetcode.algorithms.p1125.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/4/8
 * @description DP
 * 该问题可以理解为集合版的01背包问题
 * 该问题不同于常见DP的查表法（通过其他状态更新当前状态），而是需要使用刷表法（通过当前状态更新其他状态）
 * 因为使用刷表法，外层循环可以不是DP状态，DP状态可以作为内层循环
 * 本题的skill可进行int位运算优化；people可进行long位运算优化，也可用状态溯源来还原出来
 */
public class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int m = req_skills.length, n = people.size();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(req_skills[i], i);
        }
        int[] pSkills = new int[n];
        for (int i = 0, idx; i < n; i++) {
            for (String skill : people.get(i)) {
                if ((idx = map.getOrDefault(skill, -1)) >= 0) {
                    pSkills[i] |= 1 << idx;
                }
            }
        }

        int total = 1 << m;
        int[] dp = new int[total];
        int[][] pre = new int[total][2];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int p = 0; p < total; p++) {
                int combo = pSkills[i] | p;
                if (dp[combo] > dp[p] + 1) {
                    dp[combo] = dp[p] + 1;
                    pre[combo][0] = i;
                    pre[combo][1] = p;
                }
            }
        }
        int[] ans = new int[dp[total - 1]];
        for (int i = total - 1, idx = 0; i > 0; i = pre[i][1]) {
            ans[idx++] = pre[i][0];
        }
        return ans;
    }
}
