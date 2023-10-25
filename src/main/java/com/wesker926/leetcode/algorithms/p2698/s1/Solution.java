package com.wesker926.leetcode.algorithms.p2698.s1;

/**
 * @author wesker.gh
 * @date 2023/10/25
 * @description 回溯
 * 任何十进制数模9等于它的各位数相加模9
 */
public class Solution {

    private static int idx = 1;

    private static final int[] MEMORY = new int[1001];

    public int punishmentNumber(int n) {
        if (idx > n) return MEMORY[n];
        for (; idx <= n; idx++) {
            MEMORY[idx] = MEMORY[idx - 1];
            if ((idx % 9 == idx * idx % 9) && dfs(idx, 0, String.valueOf(idx * idx).toCharArray(), 0))
                MEMORY[idx] += idx * idx;
        }
        return MEMORY[n];
    }

    private boolean dfs(int num, int sum, char[] cs, int idx) {
        if (idx == cs.length) return sum == num;
        for (int cur = 0; idx < cs.length; idx++) {
            cur = cur * 10 + cs[idx] - '0';
            if (dfs(num, sum + cur, cs, idx + 1)) return true;
        }
        return false;
    }
}
