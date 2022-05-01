package com.wesker926.leetcode.algorithms.p0054.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description 螺旋遍历（同lcof-p029）
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] steps = new int[][]{{0, 1, n}, {1, 0, m - 1}, {0, -1, n - 1}, {-1, 0, m - 2}};
        List<Integer> ans = new LinkedList<>();
        for (int i = 0, x = 0, y = -1; steps[i][2] > 0; i = (i + 1) % 4) {
            for (int c = 0; c < steps[i][2]; c++) {
                x += steps[i][0];
                y += steps[i][1];
                ans.add(matrix[x][y]);
            }
            steps[i][2] -= 2;
        }
        return ans;
    }
}
