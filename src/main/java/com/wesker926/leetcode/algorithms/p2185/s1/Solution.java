package com.wesker926.leetcode.algorithms.p2185.s1;

/**
 * @author wesker.gh
 * @date 2023/1/8
 * @description 模拟
 * 内置库方法更快
 */
public class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            ans += word.startsWith(pref) ? 1 : 0;
        }
        return ans;
    }
}
