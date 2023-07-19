package com.wesker926.leetcode.algorithms.p0874.s1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2023/7/19
 * @description 模拟
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> blocks = new HashSet<>();
        for (int[] o : obstacles) blocks.add(encode(o[0], o[1]));
        int ans = 0, x = 0, y = 0, d = 0;
        for (int c : commands) {
            if (c < 0) {
                d = (-2 * c - 1 + d) % 4;
                continue;
            }
            int[] dir = DIRS[d];
            for (; c > 0 && !blocks.contains(encode(x + dir[0], y + dir[1])); c--, x += dir[0], y += dir[1]) ;
            ans = Math.max(ans, x * x + y * y);
        }
        return ans;
    }

    private int encode(int x, int y) {
        return (x + 30000) * 60001 + (y + 30000);
    }
}
