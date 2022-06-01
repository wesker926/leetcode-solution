package com.wesker926.leetcode.algorithms.p0473.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/6/1
 * @description 回溯
 * 正经说这种解法会超时的
 */
public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int stick : matchsticks) {
            sum += stick;
        }
        // 4的倍数
        if ((sum & 3) != 0) {
            return false;
        }
        // 递减排序
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        return backtracking(matchsticks, new int[4], 0, 0, sum >> 2);
    }

    private boolean backtracking(int[] sticks, int[] group, int idx, int pre, int limit) {
        if (idx == sticks.length) {
            return group[0] == group[1] && group[0] == group[2] && group[0] == group[3];
        }
        // 剪枝
        if (sticks[idx] > limit) {
            return false;
        }
        for (int i = 0; i < group.length; i++) {
            // 剪枝
            if (group[i] + sticks[idx] > limit) {
                continue;
            }
            // 剪枝
            if (idx != 0 && sticks[idx] == sticks[idx - 1] && i < pre) {
                continue;
            }
            group[i] += sticks[idx];
            if (backtracking(sticks, group, idx + 1, i, limit)) {
                return true;
            }
            group[i] -= sticks[idx];
        }
        return false;
    }
}
