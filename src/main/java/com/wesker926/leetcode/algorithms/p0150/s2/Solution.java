package com.wesker926.leetcode.algorithms.p0150.s2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author wesker.gh
 * @date 2022/5/27
 * @description 栈模拟（哈希表映射）
 */
public class Solution {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> MAP;

    static {
        MAP = new HashMap<>();
        MAP.put("+", (a, b) -> a + b);
        MAP.put("-", (a, b) -> a - b);
        MAP.put("*", (a, b) -> a * b);
        MAP.put("/", (a, b) -> a / b);
    }

    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int idx = 0;
        for (String token : tokens) {
            if (token.length() != 1 || Character.isDigit(token.charAt(0))) {
                stack[idx++] = Integer.parseInt(token);
                continue;
            }
            if (idx < 2 || !MAP.containsKey(token)) {
                return 0;
            }
            stack[idx - 2] = MAP.get(token).apply(stack[idx - 2], stack[idx - 1]);
            idx--;
        }
        return idx == 0 ? 0 : stack[idx - 1];
    }
}
