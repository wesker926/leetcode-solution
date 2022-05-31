package com.wesker926.leetcode.lcof2.p114.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/5/31
 * @description 拓扑排序
 * 这是一种BFS写法
 * 注意：如果s2是s1的真前缀，则不存在合法顺序
 * 如["abc","ab"]
 */
public class Solution {
    public String alienOrder(String[] words) {
        boolean[] appear = new boolean[26];
        boolean[][] graph = new boolean[26][26];
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                appear[word.charAt(j) - 'a'] = true;
            }
        }
        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i - 1], words[i], graph)) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (; ; ) {
            int tar = -1;
            for (int i, j = 0; j < 26; j++) {
                if (!appear[j]) {
                    continue;
                }
                for (i = 0; i < 26; i++) {
                    if (graph[i][j]) {
                        break;
                    }
                }
                if (i == 26) {
                    tar = j;
                    break;
                }
            }
            if (tar < 0) {
                break;
            }
            sb.append((char) (tar + 'a'));
            appear[tar] = false;
            Arrays.fill(graph[tar], false);
        }
        for (boolean b : appear) {
            if (b) {
                return "";
            }
        }
        return sb.toString();
    }

    private boolean compare(String s1, String s2, boolean[][] graph) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                graph[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'] = true;
                return true;
            }
        }
        return s1.length() <= s2.length();
    }
}
