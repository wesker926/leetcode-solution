package com.wesker926.leetcode.algorithms.s0901to0950.s0909;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker
 * @date 2021/6/27
 * @description 909. 蛇梯棋
 */
public class Solution {
    public int snakesAndLadders(int[][] board) {
        int len = board.length, max = len * len, step = 1, count = 1, cur, nxt;
        int[] idx;
        boolean[] visit = new boolean[max + 1];
        Queue<Integer> queue = new LinkedList<>();
        visit[1] = true;
        queue.offer(1);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                nxt = cur + i;
                if (nxt > max) {
                    break;
                }
                idx = getIdx(nxt, len);
                if (board[idx[0]][idx[1]] > 0) {
                    nxt = board[idx[0]][idx[1]];
                }
                if (nxt == max) {
                    return step;
                }
                if (!visit[nxt]) {
                    queue.offer(nxt);
                    visit[nxt] = true;
                }
            }

            count--;
            if (count == 0) {
                step++;
                count = queue.size();
            }
        }
        return -1;
    }

    private int[] getIdx(int num, int n) {
        int r = (num - 1) / n, c = (num - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }
}
