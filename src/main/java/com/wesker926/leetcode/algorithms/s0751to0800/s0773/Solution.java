package com.wesker926.leetcode.algorithms.s0751to0800.s0773;

import java.util.*;

/**
 * @author wesker
 * @date 2021/6/26
 * @description 773. 滑动谜题
 */
public class Solution {

    private static final int[][] NEIGHBORS = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        String finish = "123450", start;
        StringBuilder sb = new StringBuilder();
        for (int[] i : board) {
            for (int j : i) {
                sb.append(j);
            }
        }
        if (finish.equals((start = sb.toString()))) {
            return 0;
        }

        int step = 1, count = 1;
        String cur;
        Queue<String> queue = new LinkedList<>();
        Set<String> arrive = new HashSet<>();
        queue.offer(start);
        arrive.add(start);

        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (String s : getNext(cur)) {
                if (!arrive.contains(s)) {
                    if (finish.equals(s)) {
                        return step;
                    }
                    queue.offer(s);
                    arrive.add(s);
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

    private List<String> getNext(String cur) {
        List<String> list = new ArrayList<>(3);
        char[] cs = cur.toCharArray();
        int c = cur.indexOf('0');
        for (int i : NEIGHBORS[c]) {
            swap(cs, c, i);
            list.add(new String(cs));
            swap(cs, c, i);
        }
        return list;
    }

    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }
}
