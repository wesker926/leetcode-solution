package com.wesker926.leetcode.algorithms.p0132.s1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/21
 * @description 两次DP
 */
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        List<List<Integer>> pres = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            pres.add(new LinkedList<>());
        }
        boolean[] dp = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                dp[j] = i == j || (cs[i] == cs[j] && (j - i == 1 || dp[j - 1]));
                if (dp[j]) {
                    pres.get(j).add(i);
                }
            }
        }
        int[] count = new int[n + 1];
        count[0] = -1;
        for (int i = 1; i < n; i++) {
            int min = count[i];
            for (int pre : pres.get(i)) {
                min = Math.min(min, count[pre]);
            }
            count[i + 1] = min + 1;
        }
        return count[n];
    }
}
