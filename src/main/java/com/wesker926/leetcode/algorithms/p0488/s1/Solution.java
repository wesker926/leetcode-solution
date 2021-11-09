package com.wesker926.leetcode.algorithms.p0488.s1;

import java.util.HashMap;

/**
 * @author wesker.gh
 * @date 2021/11/9
 * @description 暴力搜索
 */
public class Solution {

    private static final int BIG = 666;

    private String hand;

    private int len;

    private HashMap<String, Integer> map;

    public int findMinStep(String board, String hand) {
        this.hand = hand;
        this.len = hand.length();
        this.map = new HashMap<>();
        int res = dfs(board, 0);
        return res == BIG ? -1 : res;
    }

    private int dfs(String board, int cur) {
        if (board.length() == 0) {
            return 0;
        }

        if (map.containsKey(board)) {
            return map.get(board);
        }

        int nxt, res = BIG;
        StringBuilder nxtBoard;
        for (int i = 0; i < len; i++) {
            if (((cur >>> i) & 1) == 1) {
                continue;
            }
            nxt = cur | (1 << i);
            for (int j = 0; j < board.length(); j++) {
                nxtBoard = new StringBuilder();
                remove(nxtBoard
                        .append(board, 0, j)
                        .append(this.hand, i, i + 1)
                        .append(board, j, board.length()), j);
                res = Math.min(dfs(nxtBoard.toString(), nxt) + 1, res);
            }
        }
        this.map.put(board, res);
        return res;
    }

    private void remove(StringBuilder sb, int i) {
        int l, r;
        while (i >= 0 && i < sb.length()) {
            for (l = i; l >= 0 && sb.charAt(l) == sb.charAt(i); l--) {
            }
            for (r = i; r < sb.length() && sb.charAt(r) == sb.charAt(i); r++) {
            }

            if (r - l > 3) {
                sb.delete(l + 1, r);
                i = l >= 0 ? l : r;
            } else {
                break;
            }
        }
    }
}
