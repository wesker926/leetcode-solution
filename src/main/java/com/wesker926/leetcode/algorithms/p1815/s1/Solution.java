package com.wesker926.leetcode.algorithms.p1815.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/1/22
 * @description 状态压缩 + DP
 * 1.取模是重要思路
 * 2.预先摘除模0以及两两成对的部分，可以减少后续步数，算是优化
 * 3.转移方程f([a1],[a2]...[ai]...[an-1]) = max(f([a1],[a2]...[ai]-1...[an-1]) + ((i == sum) mod batch) ? 1 : 0)
 */
public class Solution {

    private static final int WIDTH = 5;

    private static final int MASK = 31;

    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] mod = new int[batchSize];
        for (int group : groups) {
            mod[group % batchSize]++;
        }
        long ans = mod[0], state = 0;
        for (int i = 1, cur; i <= batchSize / 2; i++) {
            if (i * 2 == batchSize) {
                cur = mod[i] / 2;
                state |= (long) (mod[i] & 1) << ((i - 1) * WIDTH);
            } else {
                cur = Math.min(mod[i], mod[batchSize - i]);
                state |= ((long) (mod[i] - cur) << ((i - 1) * WIDTH)) | ((long) (mod[batchSize - i] - cur) << ((batchSize - i - 1) * WIDTH));
            }
            ans += cur;
        }
        return (int) ans + dfs(new HashMap<>() {{
            put(0L, 0);
        }}, batchSize, state);
    }

    private int dfs(Map<Long, Integer> memory, int batchSize, long state) {
        if (memory.containsKey(state)) {
            return memory.get(state);
        }
        int sum = 0, max = 0;
        for (int i = 1; i < batchSize; i++) {
            sum += i * ((state >> (i - 1) * WIDTH) & MASK);
        }
        for (int i = 1; i < batchSize; i++) {
            if (((state >> (i - 1) * WIDTH) & MASK) == 0) {
                continue;
            }
            max = Math.max(max, dfs(memory, batchSize, state - (1L << (i - 1) * WIDTH)) + ((sum - i) % batchSize == 0 ? 1 : 0));
        }
        memory.put(state, max);
        return max;
    }
}
