package com.wesker926.leetcode.algorithms.p1996.s2;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/1/28
 * @description 排序（0降1升）
 */
public class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        int ans = 0, max = 0;
        for (int[] cur : properties) {
            if (cur[1] < max) {
                ans++;
            } else {
                max = cur[1];
            }
        }
        return ans;
    }
}
