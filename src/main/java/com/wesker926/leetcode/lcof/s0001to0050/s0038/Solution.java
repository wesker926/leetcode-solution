package com.wesker926.leetcode.lcof.s0001to0050.s0038;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2021/6/22
 * @description 剑指 Offer 38. 字符串的排列
 */
public class Solution {
    /**
     * 交换递归
     */
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }

        List<String> list = new LinkedList<>();
        recursion(s.toCharArray(), 0, list);
        return list.toArray(new String[0]);
    }

    private void recursion(char[] cs, int k, List<String> list) {
        if (k == cs.length - 1) {
            list.add(new String(cs));
            return;
        }

        int[] set = new int[26];
        for (int i = k; i < cs.length; i++) {
            if (set[cs[i] - 'a'] != 0) {
                continue;
            }
            swap(cs, k, i);
            recursion(cs, k + 1, list);
            swap(cs, k, i);
            set[cs[i] - 'a'] = 1;
        }
    }

    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }
}
