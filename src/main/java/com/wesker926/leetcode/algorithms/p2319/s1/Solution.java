package com.wesker926.leetcode.algorithms.p2319.s1;

/**
 * @author wesker.gh
 * @date 2023/1/31
 * @description 遍历
 * 技巧：如果判断两个条件都为真或都为假，即可写为比较形式来简化逻辑
 */
public class Solution {
    public boolean checkXMatrix(int[][] grid) {
        for (int n = grid.length, i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j || i + j == n - 1) == (grid[i][j] == 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
