package com.wesker926.leetcode.algorithms.p0038.s1;

/**
 * @author wesker.gh
 * @date 2022/4/28
 * @description 遍历 + 记表
 */
public class Solution {

    private static int idx = 1;

    private static final String[] cache;

    static {
        cache = new String[30];
        cache[0] = "1";
    }

    public String countAndSay(int n) {
        if (n <= idx) {
            return cache[n - 1];
        }
        for (; idx < n; idx++) {
            cache[idx] = compute(idx - 1);
        }
        return cache[n - 1];
    }

    private String compute(int k) {
        char[] cs = cache[k].toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; j <= cs.length; j++) {
            if (j == cs.length || cs[j] != cs[i]) {
                sb.append(j - i).append(cs[i]);
                i = j;
            }
        }
        return sb.toString();
    }
}
