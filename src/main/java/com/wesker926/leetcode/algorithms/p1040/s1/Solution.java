package com.wesker926.leetcode.algorithms.p1040.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/4/7
 * @description 排序 + 双指针
 * 据说是中等里的top，偏OJ风格的思维题
 */
public class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length, min = n;
        for (int i = 0, j = 0; j < n && min != 0; j++) {
            int capacity = stones[j] - stones[i] + 1, count = j - i + 1;
            if (capacity < n) {
                continue;
            } else if (capacity == n && count == n) {
                min = 0;
                break;
            }

            if (count == n) {
                capacity = stones[j] - stones[++i] + 1;
            }
            min = Math.min(min, n + i - j - 1 + (capacity == n ? 0 : 1));
            for (; stones[j] - stones[i] + 1 >= n; i++) ;
        }
        return new int[]{min, stones[n - 1] - stones[0] + 1 - n - Math.min(stones[1] - stones[0] - 1, stones[n - 1] - stones[n - 2] - 1)};
    }
}
