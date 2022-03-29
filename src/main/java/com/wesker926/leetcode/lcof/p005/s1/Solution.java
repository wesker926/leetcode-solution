package com.wesker926.leetcode.lcof.p005.s1;

/**
 * @author wesker.gh
 * @date 2022/3/29
 * @description 遍历
 */
public class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == ' ' ? "%20" : c);
        }
        return sb.toString();
    }
}
