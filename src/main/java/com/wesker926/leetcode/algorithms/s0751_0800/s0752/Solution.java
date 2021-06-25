package com.wesker926.leetcode.algorithms.s0751_0800.s0752;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2021/6/25
 * @description 752. 打开转盘锁
 */
class Solution {
    /**
     * 只会BFS，更优的那个看不懂。。。
     */
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (start.equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains(start)) {
            return -1;
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
                if (!arrive.contains(s) && !dead.contains(s)) {
                    if (target.equals(s)) {
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
        List<String> next = new ArrayList<>(8);
        char[] cs = cur.toCharArray();
        char c;
        for (int i = 0; i < 4; i++) {
            c = cs[i];
            cs[i] = c == '0' ? '9' : (char) (c - 1);
            next.add(new String(cs));
            cs[i] = c == '9' ? '0' : (char) (c + 1);
            next.add(new String(cs));
            cs[i] = c;
        }
        return next;
    }
}
