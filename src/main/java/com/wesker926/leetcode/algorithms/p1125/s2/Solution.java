package com.wesker926.leetcode.algorithms.p1125.s2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/4/8
 * @description DP
 * 本题采用刷表法，当前状态仅会影响其后的状态，因此DP状态也可以作为外层循环
 * 可以预先精简掉没有技能的人和可以被别人替代的人
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
        for (int i = 0; i < n; i++) {
            if (pSkills[i] == 0) continue;
            for (int j = 0; j < n; j++) {
                if (i == j || pSkills[j] == 0) continue;
                if (((pSkills[i] ^ pSkills[j]) & pSkills[j]) == 0) {
                    pSkills[j] = 0;
                }
            }
        }

        int count = 0;
        for (int pSkill : pSkills) {
            if (pSkill != 0) count++;
        }
        int[] peoples = new int[count];
        for (int i = 0; i < n; i++) {
            if (pSkills[i] != 0) peoples[--count] = i;
        }

        int total = 1 << m;
        int[] dp = new int[total];
        int[][] pre = new int[total][2];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < total; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int p : peoples) {
                int combo = i | pSkills[p];
                if (dp[combo] <= dp[i] + 1) continue;
                dp[combo] = dp[i] + 1;
                pre[combo][0] = p;
                pre[combo][1] = i;
            }
        }
        int[] ans = new int[dp[total - 1]];
        for (int i = total - 1, idx = 0; i > 0; i = pre[i][1]) {
            ans[idx++] = pre[i][0];
        }
        return ans;
    }
}
