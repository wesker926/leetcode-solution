package com.wesker926.leetcode.lcof.p050.s1;

/**
 * @author wesker.gh
 * @date 2022/4/15
 * @description 遍历 + 哈希表
 */
public class Solution {
    public char firstUniqChar(String s) {
        int[] table = new int[26];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            table[cs[i] - 'a'] = table[cs[i] - 'a'] == 0 ? (i + 1) : -1;
        }
        char ans = ' ';
        for (int i = 0, min = cs.length+1; i < table.length; i++) {
            if (table[i] > 0 && table[i] < min) {
                min = table[i];
                ans = (char)(i + 'a');
            }
        }
        return ans;
    }
}
