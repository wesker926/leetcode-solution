package com.wesker926.leetcode.algorithms.p0241.s1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/7/1
 * @description 记忆化搜索
 */
public class Solution {

    private static final int ADD = -1;

    private static final int SUB = -2;

    private static final int MUL = -3;

    private static final Map<Character, Integer> MAPPING = new HashMap<>();

    static {
        MAPPING.put('+', ADD);
        MAPPING.put('-', SUB);
        MAPPING.put('*', MUL);
    }

    @SuppressWarnings("all")
    public List<Integer> diffWaysToCompute(String expression) {
        int count = 1;
        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                count += 2;
            }
        }
        int[] ops = new int[count];
        for (int i = 0, j = 0, idx = 0; j <= expression.length(); j++) {
            if (j == expression.length() || !Character.isDigit(expression.charAt(j))) {
                ops[idx++] = Integer.parseInt(expression.substring(i, j));
                if (j != expression.length()) {
                    ops[idx++] = MAPPING.get(expression.charAt(j));
                }
                i = j + 1;
            }
        }
        return dfs(ops, 0, ops.length - 1, new List[ops.length][ops.length]);
    }

    private List<Integer> dfs(int[] ops, int l, int r, List<Integer>[][] dp) {
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        if (l == r) {
            return List.of(ops[l]);
        }
        dp[l][r] = new ArrayList<>();
        for (int i = l; i < r; i += 2) {
            List<Integer> left = dfs(ops, l, i, dp);
            List<Integer> right = dfs(ops, i + 2, r, dp);
            for (Integer lv : left) {
                for (Integer rv : right) {
                    dp[l][r].add(compute(lv, rv, ops[i + 1]));
                }
            }
        }
        return dp[l][r];
    }

    private int compute(int a, int b, int op) {
        switch (op) {
            case ADD:
                return a + b;
            case SUB:
                return a - b;
            case MUL:
                return a * b;
        }
        return 0;
    }
}
