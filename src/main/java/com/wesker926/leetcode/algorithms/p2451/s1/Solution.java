package com.wesker926.leetcode.algorithms.p2451.s1;

/**
 * @author wesker.gh
 * @date 2023/5/25
 * @description 遍历
 * 不需要计算出差值数组，直接比较字符串即可
 */
public class Solution {
    public String oddString(String[] words) {
        if (isDiff(words[0], words[1]) && isDiff(words[0], words[2])) return words[0];
        for (int i = 1; i < words.length; i++) {
            if (isDiff(words[0], words[i])) return words[i];
        }
        return null;
    }

    private boolean isDiff(String a, String b) {
        int diff = a.charAt(0) - b.charAt(0);
        for (int i = 1; i < a.length(); i++) if (a.charAt(i) - b.charAt(i) != diff) return true;
        return false;
    }
}
