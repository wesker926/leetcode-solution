package com.wesker926.leetcode.algorithms.p2490.s1;

/**
 * @author wesker.gh
 * @date 2023/6/30
 * @description 遍历
 */
public class Solution {
    public boolean isCircularSentence(String sentence) {
        for (int i = 0; i < sentence.length() - 2; i++)
            if (sentence.charAt(i + 1) == ' ' && sentence.charAt(i) != sentence.charAt(i + 2)) return false;
        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
    }
}
