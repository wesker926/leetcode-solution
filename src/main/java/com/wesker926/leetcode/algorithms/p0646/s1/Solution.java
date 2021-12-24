package com.wesker926.leetcode.algorithms.p0646.s1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wesker.gh
 * @date 2021/12/24
 * @description 贪心
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));
        int ans = 1;
        for (int i = 1, limit = pairs[0][1]; i < pairs.length; i++) {
            if (pairs[i][0] <= limit) {
                continue;
            }
            ans++;
            limit = pairs[i][1];
        }
        return ans;
    }
}
