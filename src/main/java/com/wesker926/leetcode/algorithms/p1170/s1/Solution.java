package com.wesker926.leetcode.algorithms.p1170.s1;

/**
 * @author wesker.gh
 * @date 2023/6/10
 * @description 后缀和
 * 其实还有点离线计算的味道
 */
public class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] count = new int[12];
        for (String word : words) count[getFreq(word)]++;
        for (int i = count.length - 2; i > 0; i--) count[i] += count[i + 1];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) ans[i] = count[getFreq(queries[i]) + 1];
        return ans;
    }

    private int getFreq(String s) {
        int min = 'z' + 1, count = 0;
        for (char c : s.toCharArray()) {
            if (c < min) {
                min = c;
                count = 1;
            } else if (c == min) count++;
        }
        return count;
    }
}
