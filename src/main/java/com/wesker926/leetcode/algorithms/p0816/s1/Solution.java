package com.wesker926.leetcode.algorithms.p0816.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/11/7
 * @description 纯纯的暴力
 */
public class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new LinkedList<>();
        for (int i = 1; i < s.length() - 2; i++) {
            for (String s1 : single(s.substring(1, i + 1))) {
                for (String s2 : single(s.substring(i + 1, s.length() - 1))) {
                    res.add("(" + s1 + ", " + s2 + ")");
                }
            }
        }
        return res;
    }

    private List<String> single(String s) {
        List<String> res = new LinkedList<>();
        boolean headZero = s.charAt(0) == '0', tailZero = s.charAt(s.length() - 1) == '0';
        boolean self = s.length() == 1 || !headZero, point = s.length() > 1 && !tailZero;
        if (self) {
            res.add(s);
        }
        if (point) {
            for (int i = 0; i < (headZero ? 1 : s.length() - 1); i++) {
                res.add(s.substring(0, i + 1) + "." + s.substring(i + 1));
            }
        }
        return res;
    }
}
