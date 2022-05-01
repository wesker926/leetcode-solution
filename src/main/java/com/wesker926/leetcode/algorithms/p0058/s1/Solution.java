package com.wesker926.leetcode.algorithms.p0058.s1;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description 双指针
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        char[] cs = s.toCharArray();
        int i = cs.length - 1, j = i;
        for (; j >= 0; j--) {
            if (cs[j] == ' ') {
                if (i != j) {
                    break;
                }
                i = j - 1;
            }
        }
        return i - j;
    }
}
