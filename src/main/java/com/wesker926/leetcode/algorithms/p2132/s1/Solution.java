package com.wesker926.leetcode.algorithms.p2132.s1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2023/12/14
 * @description 前缀和
 * 这个虽然过了但是效果很差，后面研究下官解看看怎么优化
 * https://leetcode.cn/problems/stamping-the-grid/solutions/2562069/yong-you-piao-tie-man-wang-ge-tu-by-leet-kiaq/?envType=daily-question&envId=2023-12-14
 */
public class Solution {
    public boolean possibleToStamp(int[][] grid, int h, int w) {
        int m = grid.length, n = grid[0].length, cnt = 0;
        int[][][] t = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            t[i][0][0] = 1 - grid[i][0];
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) continue;
                t[i][j][0] = 1 + t[i][j - 1][0];
            }
        }
        System.out.println(Arrays.deepToString(t));
        for (int j = 0; j < n; j++) {
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) cnt++;
                while (!queue.isEmpty() && i - queue.peekLast() >= h) queue.pollLast();
                while (!queue.isEmpty() && t[queue.peekFirst()][j][0] >= t[i][j][0]) queue.pollFirst();
                queue.offerFirst(i);
                t[i][j][1] = t[queue.peekLast()][j][0] >= w && i >= h - 1 ? 1 : 0;
            }
        }
        System.out.println(Arrays.deepToString(t));
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                t[i][j][0] = t[i][j][1];
                if (j < n - 1) t[i][j][0] += t[i][j + 1][0];
                if (j < n - w) t[i][j][0] -= t[i][j + w][1];
            }
        }
        System.out.println(Arrays.deepToString(t));
        for (int j = n - 1; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                t[i][j][1] = t[i][j][0];
                if (i < m - 1) t[i][j][1] += t[i + 1][j][1];
                if (i < m - h) t[i][j][1] -= t[i + h][j][0];
                if (grid[i][j] == 0 && t[i][j][1] > 0) cnt--;
            }
        }
        System.out.println(Arrays.deepToString(t));
        return cnt == 0;
    }
}
