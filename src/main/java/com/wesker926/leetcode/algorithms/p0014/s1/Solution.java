package com.wesker926.leetcode.algorithms.p0014.s1;

/**
 * @author wesker.gh
 * @date 2022/4/22
 * @description 纵向扫描
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String main = strs[0];
        for (int i = 0; i < main.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || main.charAt(i) != strs[j].charAt(i)) {
                    return main.substring(0, i);
                }
            }
        }
        return main;
    }
}
