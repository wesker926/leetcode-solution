package com.wesker926.leetcode.algorithms.p0087.s1;

/**
 * @author wesker.gh
 * @date 2022/5/7
 * @description 自顶向下动态规划（记忆化搜索）
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        return dfs(s1.toCharArray(), s2.toCharArray(), new int[len][len][len + 1], 0, 0, len);
    }

    private boolean dfs(char[] cs1, char[] cs2, int[][][] memory, int s1, int s2, int len) {
        if (memory[s1][s2][len] != 0) {
            return memory[s1][s2][len] == 1;
        }

        if (isEqual(cs1, cs2, s1, s2, len)) {
            memory[s1][s2][len] = 1;
            return true;
        }

        if (!isEqualCharNum(cs1, cs2, s1, s2, len)) {
            memory[s1][s2][len] = -1;
            return false;
        }

        for (int i = 1; i < len; i++) {
            if (dfs(cs1, cs2, memory, s1, s2, i) && dfs(cs1, cs2, memory, s1 + i, s2 + i, len - i)) {
                memory[s1][s2][len] = 1;
                return true;
            }

            if (dfs(cs1, cs2, memory, s1, s2 + len - i, i) && dfs(cs1, cs2, memory, s1 + i, s2, len - i)) {
                memory[s1][s2][len] = 1;
                return true;
            }
        }
        memory[s1][s2][len] = -1;
        return false;
    }

    private boolean isEqual(char[] cs1, char[] cs2, int s1, int s2, int len) {
        for (int i = 0; i < len; i++) {
            if (cs1[s1 + i] != cs2[s2 + i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isEqualCharNum(char[] cs1, char[] cs2, int s1, int s2, int len) {
        int[] bucket = new int[26];
        for (int i = 0; i < len; i++) {
            bucket[cs1[s1 + i] - 'a']++;
            bucket[cs2[s2 + i] - 'a']--;
        }
        for (int i : bucket) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
