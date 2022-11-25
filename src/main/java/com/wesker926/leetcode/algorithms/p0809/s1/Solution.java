package com.wesker926.leetcode.algorithms.p0809.s1;

/**
 * @author wesker.gh
 * @date 2022/11/25
 * @description 双指针
 * 先对s做了处理，但是效果不太好
 */
public class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0, m = 0;
        int[][] letters = new int[100][2];
        for (int i = 0, j = 1; j <= s.length(); j++) {
            if (j == s.length() || s.charAt(j) != s.charAt(j - 1)) {
                letters[m][0] = s.charAt(j - 1);
                letters[m++][1] = j - i;
                i = j;
            }
        }
        for (String word : words) {
            int idx = 0, n = word.length();
            for (int i = 0, j = 1; j <= n; j++) {
                if (j != n && word.charAt(j) == word.charAt(j - 1)) {
                    continue;
                }
                int ch1 = letters[idx][0], ch2 = word.charAt(j - 1), c1 = letters[idx][1], c2 = j - i;
                if (ch1 != ch2 || c2 > c1 || (c2 != c1 && c1 < 3) || (idx == m - 1 && j != n)) {
                    break;
                }
                idx++;
                i = j;
            }
            ans += idx == m ? 1 : 0;
        }
        return ans;
    }
}
