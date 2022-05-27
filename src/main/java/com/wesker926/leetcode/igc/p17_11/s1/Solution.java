package com.wesker926.leetcode.igc.p17_11.s1;

/**
 * @author wesker.gh
 * @date 2022/5/27
 * @description 一次遍历
 * 找到目标单词后，只考虑向前比较，并且只需要比较最近的另一个单词
 */
public class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int ans = words.length, idx1 = -ans, idx2 = -ans;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
                ans = Math.min(ans, idx1 - idx2);
            } else if (words[i].equals(word2)) {
                idx2 = i;
                ans = Math.min(ans, idx2 - idx1);
            }
        }
        return ans;
    }
}
