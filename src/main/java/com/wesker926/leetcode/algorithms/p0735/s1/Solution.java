package com.wesker926.leetcode.algorithms.p0735.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/7/13
 * @description 栈
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int idx = 0;
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack[idx++] = asteroid;
                continue;
            }
            while (idx != 0 && stack[idx - 1] > 0 && stack[idx - 1] < -asteroid) {
                idx--;
            }
            if (idx == 0 || stack[idx - 1] < 0) {
                stack[idx++] = asteroid;
            } else if (stack[idx - 1] == -asteroid) {
                idx--;
            }
        }
        return Arrays.copyOf(stack, idx);
    }
}
