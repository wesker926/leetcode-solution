package com.wesker926.leetcode.algorithms.p0500.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2021/10/31
 * @description character array
 */
public class Solution {

    private static final int[] chars = new int[]{2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

    public String[] findWords(String[] words) {
        List<String> list = new LinkedList<>();
        for (String s : words) {
            if (check(s)) {
                list.add(s);
            }
        }
        return list.toArray(new String[0]);
    }

    private boolean check(String s) {
        char[] cs = s.toLowerCase().toCharArray();
        int from = chars[cs[0] - 'a'];
        for (int i = 1; i < cs.length; i++) {
            if (from != chars[cs[i] - 'a']) {
                return false;
            }
        }
        return true;
    }
}
