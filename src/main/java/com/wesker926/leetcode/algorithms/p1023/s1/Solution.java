package com.wesker926.leetcode.algorithms.p1023.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/4/14
 * @description 双指针
 */
public class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        char[] p = pattern.toCharArray();
        for (String query : queries) {
            int i = 0, j = 0, isMatch = 1;
            for (; i < query.length(); i++) {
                if (j < p.length && query.charAt(i) == p[j]) {
                    j++;
                    continue;
                }
                if (Character.isUpperCase(query.charAt(i))) {
                    isMatch = 0;
                    break;
                }
            }
            ans.add(isMatch == 1 && j == pattern.length());
        }
        return ans;
    }
}
