package com.wesker926.leetcode.algorithms.p2351.s1;

/**
 * @author wesker.gh
 * @date 2023/1/1
 * @description 哈希（桶）
 * 也可以用int32省略桶
 */
public class Solution {
    public char repeatedCharacter(String s) {
        boolean[] bucket = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (bucket[ch - 'a']) {
                return ch;
            }
            bucket[ch - 'a'] = true;
        }
        return ' ';
    }
}
