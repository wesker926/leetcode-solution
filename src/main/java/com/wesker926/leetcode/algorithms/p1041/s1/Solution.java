package com.wesker926.leetcode.algorithms.p1041.s1;

/**
 * @author wesker.gh
 * @date 2023/4/11
 * @description 模拟
 * 模拟一遍，看在不在原点或方向有没有变。
 */
public class Solution {

    private static final int[][] STEP = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean isRobotBounded(String instructions) {
        int dir = 0;
        int[] pos = new int[]{0, 0};
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            if (ch == 'G') {
                pos[0] += STEP[dir][0];
                pos[1] += STEP[dir][1];
            } else {
                dir = (dir + 4 + (ch == 'R' ? 1 : -1)) % 4;
            }
        }
        return (pos[0] == 0 && pos[1] == 0) || dir != 0;
    }
}
