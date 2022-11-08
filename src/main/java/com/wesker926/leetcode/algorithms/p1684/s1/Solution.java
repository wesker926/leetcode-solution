package com.wesker926.leetcode.algorithms.p1684.s1;

/**
 * @author wesker.gh
 * @date 2022/11/8
 * @description 遍历
 * 可以用int32位运算代替哈希表
 */
public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] letters = new boolean[26];
        for (char c : allowed.toCharArray()) {
            letters[c - 'a'] = true;
        }
        int ans = 0;
        outer:
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!letters[word.charAt(i) - 'a']) {
                    continue outer;
                }
            }
            ans++;
        }
        return ans;
    }
}
