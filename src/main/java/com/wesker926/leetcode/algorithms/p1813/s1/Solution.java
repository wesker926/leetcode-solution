package com.wesker926.leetcode.algorithms.p1813.s1;

/**
 * @author wesker.gh
 * @date 2023/1/16
 * @description 切分 + 双指针
 * 不用split会挺复杂，有时间再写一下
 */
public class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" "), words2 = sentence2.split(" ");
        int i = 0, j = 0, l = Math.min(words1.length, words2.length);
        for (; i < l && words1[i].equals(words2[i]); i++) ;
        for (; j < l - i && words1[words1.length - 1 - j].equals(words2[words2.length - 1 - j]); j++) ;
        return i + j == l;
    }
}
