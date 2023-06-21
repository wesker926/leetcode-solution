package com.wesker926.leetcode.lcp.p041.s1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2023/6/21
 * @description BFS
 * 细节不少，臭又长
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public int flipChess(String[] chessboard) {
        int ans = 0;
        for (int i = 0; i < chessboard.length; i++)
            for (int j = 0; j < chessboard[0].length(); j++) {
                if (chessboard[i].charAt(j) != '.') continue;
                ans = Math.max(ans, bfs(chessboard, i, j));
            }
        return ans;
    }

    private int bfs(String[] board, int x, int y) {
        int m = board.length, n = board[0].length(), count = 0;
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = board[i].charAt(j);
        grid[x][y] = 'X';
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(encode(x, y));
        while (!queue.isEmpty()) {
            int code = queue.poll();
            for (int[] dir : DIRS) count += judgeAndOffer(grid, (code >> 4) + dir[0], (code & 15) + dir[1], dir, queue);
        }
        return count;
    }

    private int judgeAndOffer(char[][] grid, int i, int j, int[] dir, Queue<Integer> queue) {
        int m = grid.length, n = grid[0].length, count = 0;
        boolean needFlip = false;
        for (int ni = i, nj = j; inRange(m, n, ni, nj); ni += dir[0], nj += dir[1], count++) {
            if (grid[ni][nj] == '.') return 0;
            if (grid[ni][nj] == 'X') {
                needFlip = true;
                break;
            }
        }
        if (!needFlip || count == 0) return 0;
        for (count = 0; grid[i][j] == 'O'; i += dir[0], j += dir[1], count++) {
            queue.offer(encode(i, j));
            grid[i][j] = 'X';
        }
        return count;
    }

    private boolean inRange(int m, int n, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private int encode(int i, int j) {
        return (i << 4) + j;
    }
}
