package com.wesker926.leetcode.algorithms.p2309.s1;

/**
 * @author wesker.gh
 * @date 2023/1/27
 * @description 哈希表
 * 都是遍历，因此计算次数为关键
 * 26的table虽然小，但是计算量更大，58的table计算更少
 */
public class Solution {
    public String greatestLetter(String s) {
        boolean[] table = new boolean[58];
        for (char ch : s.toCharArray()) {
            table[ch - 'A'] = true;
        }
        for (int i = 25; i >= 0; i--) {
            if (table[i] && table[i + 32]) {
                return String.valueOf((char) (i + 'A'));
            }
        }
        return "";
    }
}
