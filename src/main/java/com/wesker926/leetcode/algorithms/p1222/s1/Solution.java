package com.wesker926.leetcode.algorithms.p1222.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/9/14
 * @description 模拟
 * 从国王出发更简单
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] grid = new boolean[8][8];
        for (int[] queen : queens) grid[queen[0]][queen[1]] = true;
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] dir : DIRS) {
            for (int i = king[0], j = king[1]; i >= 0 && i < 8 && j >= 0 && j < 8; i += dir[0], j += dir[1]) {
                if (grid[i][j]) {
                    ans.add(List.of(i, j));
                    break;
                }
            }
        }
        return ans;
    }
}
