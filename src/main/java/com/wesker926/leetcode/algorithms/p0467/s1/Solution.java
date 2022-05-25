package com.wesker926.leetcode.algorithms.p0467.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/5/25
 * @description DP
 * bcabcd：
 * 记录以各个字母结尾的某个连续子串的最长长度
 * 对c而言，这里有两个连续字串，bc和abc
 * 连续字串的长度同时表示以末尾结尾的字串的个数
 * bc  -> c，bc
 * abc -> c，bc，abc
 * 这里有重复，因此只记录最大的长度即可，即dp[c]=3
 * 同理可得所有dp，最后相加即为答案
 */
public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        for (int i = 0, k = 0, c; i < p.length(); i++) {
            c = p.charAt(i) - 'a';
            if (i == 0 || (p.charAt(i - 1) - 'a' + 1) % 26 == c) {
                k++;
            } else {
                k = 1;
            }
            dp[c] = Math.max(dp[c], k);
        }
        return Arrays.stream(dp).sum();
    }
}
