package com.wesker926.leetcode.algorithms.p0126.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/5/20
 * @description BFS
 * 注：如果先构建图会更快
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new LinkedList<>();
        String[] words = wordList.toArray(String[]::new);
        Queue<LinkedList<String>> queue = new LinkedList<>(List.of(new LinkedList<>(List.of(beginWord))));
        HashSet<Integer> clearIdx = new HashSet<>();
        for (int layer = 1, find = 0; !queue.isEmpty(); ) {
            LinkedList<String> cur = queue.poll();
            if (endWord.equals(cur.getLast())) {
                find = 1;
                ans.add(cur);
            }
            if (find == 0) {
                for (int i = 0; i < words.length; i++) {
                    if (words[i] != null && checkDiff(words[i], cur.getLast())) {
                        LinkedList<String> next = new LinkedList<>(cur);
                        next.add(words[i]);
                        queue.offer(next);
                        clearIdx.add(i);
                    }
                }
            }
            if (--layer == 0) {
                if (find == 1) {
                    break;
                }
                for (Integer idx : clearIdx) {
                    words[idx] = null;
                }
                layer = queue.size();
            }
        }
        return ans;
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
