package com.wesker926.leetcode.algorithms.p0127.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/5/20
 * @description BFS
 * 注：如果先构建图会更快
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>(List.of(beginWord));
        for (int layer = 1, depth = 1; !queue.isEmpty(); ) {
            String cur = queue.poll();
            if (cur.equals(endWord)) {
                return depth;
            }
            char[] cs = cur.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char origin = cs[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == origin) {
                        continue;
                    }
                    cs[i] = c;
                    String nxt = new String(cs);
                    if (!words.contains(nxt)) {
                        continue;
                    }
                    queue.offer(nxt);
                    words.remove(nxt);
                }
                cs[i] = origin;
            }
            if (--layer == 0) {
                layer = queue.size();
                depth++;
            }
        }
        return 0;
    }

    private boolean checkDiff(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
