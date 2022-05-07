package com.wesker926.leetcode.algorithms.p0085.s1;

import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/5/7
 * @description 单调栈
 * 参考p0084，对每一行算最大矩形。
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] mx = new int[m][n + 1];
        for (int j = 0, i, sum; j < n; j++) {
            for (i = 0, sum = 0; i < m; i++) {
                mx[i][j] = matrix[i][j] == '1' ? (++sum) : (sum = 0);
            }
        }
        int ans = 0;
        int[] leftLow = new int[n + 1];
        int[] rightLow = new int[n + 1];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            stack.clear();
            for (int j = 0, k; j <= n; j++) {
                while (!stack.isEmpty() && mx[i][stack.peekFirst()] >= mx[i][j]) {
                    rightLow[(k = stack.pop())] = j;
                    ans = Math.max(ans, mx[i][k] * (rightLow[k] - leftLow[k] - 1));
                }
                leftLow[j] = stack.isEmpty() ? -1 : stack.peekFirst();
                stack.push(j);
            }
        }
        return ans;
    }
}
