package com.wesker926.leetcode.algorithms.p1147.s2;

/**
 * @author wesker.gh
 * @date 2023/4/12
 * @description 贪心
 */
public class Solution {
    public int longestDecomposition(String text) {
        char[] cs = text.toCharArray();
        int n = cs.length, ans = 0;
        outer:
        for (int l = 0, r = n - 1, len; l <= r; ans += 2, l += len, r -= len) {
            for (len = 1; l + len - 1 < r - len + 1; len++) {
                if (check(cs, l, r - len + 1, len)) {
                    continue outer;
                }
            }
            ans += 1;
            break;
        }
        return ans;
    }

    private boolean check(char[] cs, int i, int j, int len) {
        for (; len > 0; len--, i++, j++) {
            if (cs[i] != cs[j]) {
                return false;
            }
        }
        return true;
    }
}
