package com.wesker926.leetcode.igc.p01_02.s1;

/**
 * @author wesker.gh
 * @date 2022/9/27
 * @description 哈希表
 * 没给字符范围，放128
 */
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] table = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i)]++;
            table[s2.charAt(i)]--;
        }
        for (int count : table) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
