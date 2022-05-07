package com.wesker926.leetcode.algorithms.p0433.s1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/5/7
 * @description BFS
 */
public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int depth = 0, layer = 1;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.equals(end)) {
                return depth;
            }
            for (int i = 0; i < bank.length; i++) {
                if (bank[i] != null && checkDiff(cur, bank[i])) {
                    queue.offer(bank[i]);
                    bank[i] = null;
                }
            }
            if (--layer == 0) {
                depth++;
                layer = queue.size();
            }
        }
        return -1;
    }

    private boolean checkDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
