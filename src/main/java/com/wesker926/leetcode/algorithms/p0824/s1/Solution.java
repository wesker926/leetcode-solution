package com.wesker926.leetcode.algorithms.p0824.s1;

/**
 * @author wesker.gh
 * @date 2022/4/21
 * @description 遍历模拟
 */
public class Solution {
    public String toGoatLatin(String sentence) {
        char[] cs = sentence.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0, c = 1; j <= cs.length; j++) {
            if (j == cs.length || cs[j] == ' ') {
                char ch = Character.toLowerCase(cs[i]);
                boolean isVowel = ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
                for (int k = isVowel ? i : i + 1; k < j; k++) {
                    sb.append(cs[k]);
                }
                sb.append(isVowel ? "" : cs[i]).append("ma").append("a".repeat(c++)).append(' ');
                i = j + 1;
            }
        }
        return sb.substring(0, sb.length() - 1);
    }
}
