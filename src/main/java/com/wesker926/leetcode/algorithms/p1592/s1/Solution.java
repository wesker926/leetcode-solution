package com.wesker926.leetcode.algorithms.p1592.s1;

/**
 * @author wesker.gh
 * @date 2022/9/7
 * @description 遍历模拟
 */
public class Solution {
    public String reorderSpaces(String text) {
        int wordGap = text.charAt(text.length() - 1) == ' ' ? -1 : 0, blank = 0;
        for (int i = 0, j = 0; j < text.length(); j++) {
            if (text.charAt(j) == ' ') {
                blank++;
                if (i != j) {
                    wordGap++;
                }
                i = j + 1;
            }
        }
        int gapCount = wordGap == 0 ? 0 : blank / wordGap;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, wordIdx = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                for (; i < text.length() && text.charAt(i) != ' '; i++) {
                    sb.append(text.charAt(i));
                }
                if (wordIdx != wordGap) {
                    sb.append(" ".repeat(gapCount));
                }
                wordIdx++;
            }
        }
        return sb.append(" ".repeat(blank - gapCount * wordGap)).toString();
    }
}
