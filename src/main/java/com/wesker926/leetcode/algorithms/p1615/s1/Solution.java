package com.wesker926.leetcode.algorithms.p1615.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/3/15
 * @description 贪心
 * 这题贪心又臭又长，不如直接枚举省事儿
 */
public class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0) {
            return 0;
        }
        int[] degree = new int[n];
        boolean[][] graph = new boolean[n][n];
        for (int[] road : roads) {
            graph[road[0]][road[1]] = true;
            graph[road[1]][road[0]] = true;
            degree[road[0]]++;
            degree[road[1]]++;
        }
        int first = 0, second = 0;
        List<Integer> firstList = new ArrayList<>(), secondList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] > first) {
                second = first;
                first = degree[i];
                secondList.clear();
                secondList.addAll(firstList);
                firstList.clear();
                firstList.add(i);
            } else if (degree[i] == first) {
                firstList.add(i);
            } else if (degree[i] > second) {
                second = degree[i];
                secondList.clear();
                secondList.add(i);
            } else if (degree[i] == second) {
                secondList.add(i);
            }
        }
        if (firstList.size() != 1) {
            second = first;
            secondList = firstList;
        }
        int ans = first + second - 1;
        for (int i = 0; i < firstList.size(); i++) {
            for (int j = firstList.size() == 1 ? 0 : i + 1; j < secondList.size(); j++) {
                if (!graph[firstList.get(i)][secondList.get(j)]) {
                    return ans + 1;
                }
            }
        }
        return ans;
    }
}
