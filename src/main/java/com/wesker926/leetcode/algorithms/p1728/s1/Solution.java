package com.wesker926.leetcode.algorithms.p1728.s1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/5/10
 * @description 拓扑排序
 * 超难博弈论题目
 */
public class Solution {

    private static final int MOUSE_TURN = 0, CAT_TURN = 1, UNKNOWN_WIN = 0, MOUSE_WIN = 1, CAT_WIN = 2, MAX_MOVE = 1000;

    private static final int[][] DIRS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int m, n, mJump, cJump, foodPos = -1;

    private char[][] grid;

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        m = grid.length;
        n = grid[0].length();
        mJump = mouseJump;
        cJump = catJump;
        this.grid = new char[m][n];
        int catStartPos = -1, mouseStartPos = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.grid[i][j] = grid[i].charAt(j);
                if (this.grid[i][j] == 'C') {
                    catStartPos = getPos(i, j);
                } else if (this.grid[i][j] == 'M') {
                    mouseStartPos = getPos(i, j);
                } else if (this.grid[i][j] == 'F') {
                    foodPos = getPos(i, j);
                }
            }
        }

        int total = m * n;
        Queue<int[]> queue = new LinkedList<>();
        int[][][] degree = computeDegree(total);
        int[][][][] result = setBoundary(total, queue);
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int curMousePos = state[0], curCatPos = state[1], curTurn = state[2];
            int curResult = result[curMousePos][curCatPos][curTurn][0];
            int curMove = result[curMousePos][curCatPos][curTurn][1];
            List<int[]> preStates = getPreState(curMousePos, curCatPos, curTurn);
            for (int[] preState : preStates) {
                int preMousePos = preState[0], preCatPos = preState[1], preTurn = preState[2];
                if (result[preMousePos][preCatPos][preTurn][0] != UNKNOWN_WIN) {
                    continue;
                }
                boolean canWin = (curResult == MOUSE_WIN && preTurn == MOUSE_TURN) || (curResult == CAT_WIN && preTurn == CAT_TURN);
                if (canWin) {
                    result[preMousePos][preCatPos][preTurn][0] = curResult;
                    result[preMousePos][preCatPos][preTurn][1] = curMove + 1;
                    queue.offer(new int[]{preMousePos, preCatPos, preTurn});
                } else {
                    if (--degree[preMousePos][preCatPos][preTurn] == 0) {
                        result[preMousePos][preCatPos][preTurn][0] = preTurn == MOUSE_TURN ? CAT_WIN : MOUSE_WIN;
                        result[preMousePos][preCatPos][preTurn][1] = curMove + 1;
                        queue.offer(new int[]{preMousePos, preCatPos, preTurn});
                    }
                }
            }
        }
        return result[mouseStartPos][catStartPos][MOUSE_TURN][0] == MOUSE_WIN && result[mouseStartPos][catStartPos][MOUSE_TURN][1] <= MAX_MOVE;
    }

    private int[][][] computeDegree(int total) {
        int[][][] degree = new int[total][total][2];
        for (int mPos = 0; mPos < total; mPos++) {
            int mx = mPos / n, my = mPos % n;
            if (this.grid[mx][my] == '#') {
                continue;
            }
            for (int cPos = 0; cPos < total; cPos++) {
                int cx = cPos / n, cy = cPos % n;
                if (this.grid[cx][cy] == '#') {
                    continue;
                }
                degree[mPos][cPos][MOUSE_TURN]++;
                degree[mPos][cPos][CAT_TURN]++;
                for (int[] dir : DIRS) {
                    for (int nx = mx + dir[0], ny = my + dir[1], jump = 1; nx >= 0 && nx < m && ny >= 0 && ny < n
                            && jump <= mJump && this.grid[nx][ny] != '#'; nx += dir[0], ny += dir[1], jump++) {
                        degree[getPos(nx, ny)][cPos][MOUSE_TURN]++;
                    }
                    for (int nx = cx + dir[0], ny = cy + dir[1], jump = 1; nx >= 0 && nx < m && ny >= 0 && ny < n
                            && jump <= cJump && this.grid[nx][ny] != '#'; nx += dir[0], ny += dir[1], jump++) {
                        degree[mPos][getPos(nx, ny)][CAT_TURN]++;
                    }
                }
            }
        }
        return degree;
    }

    private int[][][][] setBoundary(int total, Queue<int[]> queue) {
        int[][][][] result = new int[total][total][2][2];
        for (int pos = 0; pos < total; pos++) {
            if (grid[pos / n][pos % n] == '#') {
                continue;
            }
            result[pos][pos][MOUSE_TURN][0] = CAT_WIN;
            result[pos][pos][MOUSE_TURN][1] = 0;
            result[pos][pos][CAT_TURN][0] = CAT_WIN;
            result[pos][pos][CAT_TURN][1] = 0;
            queue.offer(new int[]{pos, pos, MOUSE_TURN});
            queue.offer(new int[]{pos, pos, CAT_TURN});
            if (pos == foodPos) {
                continue;
            }
            result[pos][foodPos][MOUSE_TURN][0] = CAT_WIN;
            result[pos][foodPos][MOUSE_TURN][1] = 0;
            result[pos][foodPos][CAT_TURN][0] = CAT_WIN;
            result[pos][foodPos][CAT_TURN][1] = 0;
            queue.offer(new int[]{pos, foodPos, MOUSE_TURN});
            queue.offer(new int[]{pos, foodPos, CAT_TURN});

            result[foodPos][pos][MOUSE_TURN][0] = MOUSE_WIN;
            result[foodPos][pos][MOUSE_TURN][1] = 0;
            result[foodPos][pos][CAT_TURN][0] = MOUSE_WIN;
            result[foodPos][pos][CAT_TURN][1] = 0;
            queue.offer(new int[]{foodPos, pos, MOUSE_TURN});
            queue.offer(new int[]{foodPos, pos, CAT_TURN});
        }
        return result;
    }

    private List<int[]> getPreState(int curMousePos, int curCatPos, int curTurn) {
        int preTurn = curTurn == MOUSE_TURN ? CAT_TURN : MOUSE_TURN;
        int prePos = preTurn == MOUSE_TURN ? curMousePos : curCatPos;
        int jump = preTurn == MOUSE_TURN ? mJump : cJump;
        List<int[]> res = new LinkedList<>();
        res.add(new int[]{curMousePos, curCatPos, preTurn});
        for (int[] dir : DIRS) {
            for (int px = (prePos / n) + dir[0], py = (prePos % n) + dir[1], j = jump; px >= 0 && px < m && py >= 0 && py < n
                    && j > 0 && this.grid[px][py] != '#'; px += dir[0], py += dir[1], j--) {
                int preMousePos = preTurn == MOUSE_TURN ? getPos(px, py) : curMousePos;
                int preCatPos = preTurn == MOUSE_TURN ? curCatPos : getPos(px, py);
                res.add(new int[]{preMousePos, preCatPos, preTurn});
            }
        }
        return res;
    }

    private int getPos(int i, int j) {
        return i * n + j;
    }
}
