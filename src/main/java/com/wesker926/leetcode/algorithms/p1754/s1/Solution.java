package com.wesker926.leetcode.algorithms.p1754.s1;

/**
 * @author wesker.gh
 * @date 2022/12/24
 * @description 贪心
 * 其实只当两个字符相等时才需要比较后缀字符串
 * O((m + n) * max(m, n))
 */
public class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int m = word1.length(), n = word2.length();
        for (int i = 0, j = 0; i < m || j < n; ) {
            if (i < m && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }
}
