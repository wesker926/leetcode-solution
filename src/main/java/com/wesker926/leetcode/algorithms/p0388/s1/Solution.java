package com.wesker926.leetcode.algorithms.p0388.s1;

/**
 * @author wesker.gh
 * @date 2022/4/20
 * @description 栈
 */
public class Solution {
    public int lengthLongestPath(String input) {
        char[] cs = input.toCharArray();
        int[] stack = new int[input.length()];
        int ans = 0, cur = 0, idx = 0;
        for (int i = 0, j = 0, k, p = 0; j <= cs.length; j++) {
            if (j == cs.length || cs[j] == '\n') {
                for (k = i; k < j && cs[k] == '\t'; k++) {
                }
                for (; idx > k - i; idx--) {
                    cur -= stack[idx - 1];
                }
                stack[idx++] = j - k;
                cur += j - k;
                if (p == 1 && cur + idx - 1 > ans) {
                    ans = cur + idx - 1;
                }
                p = 0;
                i = j + 1;
            } else if (cs[j] == '.') {
                p = 1;
            }
        }
        return ans;
    }
}
