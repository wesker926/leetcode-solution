package com.wesker926.leetcode.algorithms.p1668.s1;

/**
 * @author wesker.gh
 * @date 2022/11/3
 * @description 土法子
 * 通过，但未证明正确性
 */
public class Solution {
    public int maxRepeating(String sequence, String word) {
        int idx = 0, ans = 0, n = word.length();
        for (int i; (i = sequence.indexOf(word, idx)) != -1; ) {
            int cur = 1;
            for (int j = i + cur * n; sequence.indexOf(word, j) == j; cur++, j = i + cur * n) {
            }
            ans = Math.max(ans, cur);
            idx = i + (cur - 1) * n + 1;
        }
        return ans;
    }
}
