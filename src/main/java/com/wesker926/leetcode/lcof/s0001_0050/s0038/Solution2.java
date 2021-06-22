package com.wesker926.leetcode.lcof.s0001_0050.s0038;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2021/6/22
 * @description 剑指 Offer 38. 字符串的排列 - 回溯剪枝
 */
public class Solution2 {
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }

        List<String> list = new LinkedList<>();
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        backtrace(cs, 0, new boolean[cs.length], new StringBuilder(), list);
        return list.toArray(new String[0]);
    }

    private void backtrace(char[] cs, int k, boolean[] visit, StringBuilder sb, List<String> list) {
        if (k == cs.length) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < cs.length; i++) {
            if (visit[i] || (i > 0 && cs[i - 1] == cs[i] && !visit[i - 1])) {
                continue;
            }

            visit[i] = true;
            sb.append(cs[i]);
            backtrace(cs, k + 1, visit, sb, list);
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
        }
    }
}
