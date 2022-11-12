package com.wesker926.leetcode.algorithms.p0791.s1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/11/13
 * @description 排序
 * 普通做法
 */
public class Solution {
    public String customSortString(String order, String s) {
        int[] orders = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        List<Character> sort = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (orders[c - 'a'] == 0) {
                sb.append(c);
            } else {
                sort.add(c);
            }
        }
        sort.sort(Comparator.comparingInt(c -> orders[c - 'a']));
        for (char c : sort) {
            sb.append(c);
        }
        return sb.toString();
    }
}
