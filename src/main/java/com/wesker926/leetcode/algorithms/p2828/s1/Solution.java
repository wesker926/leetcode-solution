package com.wesker926.leetcode.algorithms.p2828.s1;

import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/12/20
 * @description 遍历
 */
public class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if (s.length() != words.size()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) return false;
        }
        return true;
    }
}
