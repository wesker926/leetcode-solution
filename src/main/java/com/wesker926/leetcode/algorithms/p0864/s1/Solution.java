package com.wesker926.leetcode.algorithms.p0864.s1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/11/10
 * @description BFS + 位运算状态压缩
 * 注意审题
 */
public class Solution {

    private static final int CODE_MASK = (1 << 16) - 1;

    private static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length(), sx = 0, sy = 0, keyMask = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    sx = i;
                    sy = j;
                } else if (Character.isLowerCase(ch)) {
                    keyMask = Math.max(keyMask, ch - 'a' + 1);
                }
            }
        }
        keyMask = (1 << keyMask) - 1;
        int startCode = encode(0, sx, sy, 0);
        boolean[] visited = new boolean[CODE_MASK + 1];
        visited[startCode] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startCode);
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int[] cur = decode(code);
            char ch = grid[cur[1]].charAt(cur[2]);
            if (Character.isLowerCase(ch)) {
                cur[3] |= 1 << (ch - 'a');
            }
            if (cur[3] == keyMask) {
                return cur[0];
            }
            for (int[] dir : DIRS) {
                int nx = cur[1] + dir[0], ny = cur[2] + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                char nCh = grid[nx].charAt(ny);
                if (nCh == '#' || (Character.isUpperCase(nCh) && (cur[3] & (1 << (nCh - 'A'))) == 0)) {
                    continue;
                }
                int nCode = encode(cur[0] + 1, nx, ny, cur[3]);
                if (visited[nCode & CODE_MASK]) {
                    continue;
                }
                visited[nCode & CODE_MASK] = true;
                queue.offer(nCode);
            }
        }
        return -1;
    }

    private int encode(int step, int x, int y, int keyBit) {
        return (step << 16) | (x << 11) | (y << 6) | keyBit;
    }

    private int[] decode(int code) {
        return new int[]{code >> 16, (code >> 11) & 31, (code >> 6) & 31, code & 63};
    }
}
