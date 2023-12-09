package com.wesker926.leetcode.algorithms.p2048.s1;

/**
 * @author wesker.gh
 * @date 2023/12/9
 * @description 枚举
 * 也可以打表，什么疯批题
 */
public class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) if (isBalance(i)) return i;
    }

    private boolean isBalance(int x) {
        int[] cnt = new int[10];
        for (; x > 0; x /= 10) cnt[x % 10]++;
        for (int i = 0; i < 10; i++) if (cnt[i] != 0 && cnt[i] != i) return false;
        return true;
    }
}
