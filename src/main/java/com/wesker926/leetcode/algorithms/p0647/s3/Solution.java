package com.wesker926.leetcode.algorithms.p0647.s3;

/**
 * @author wesker.gh
 * @date 2021/12/24
 * @description Manacher（马拉车算法）
 */
public class Solution {
    public int countSubstrings(String s) {
        char[] cs = new char[s.length() * 2 + 3];
        int idx = 0;
        cs[idx++] = '!';
        for (char c : s.toCharArray()) {
            cs[idx++] = '#';
            cs[idx++] = c;
        }
        cs[idx++] = '#';
        cs[idx] = '$';

        int ans = 0;
        int[] f = new int[cs.length];
        for (int i = 1, im = 0, rm = 0; i < cs.length - 1; i++) {
            f[i] = i <= rm ? Math.min(rm - i + 1, f[im * 2 - i]) : 1;
            while (cs[i + f[i]] == cs[i - f[i]]) {
                f[i]++;
            }
            if (i + f[i] - 1 > rm) {
                rm = i + f[i] - 1;
                im = i;
            }
            ans += f[i] / 2;
        }
        return ans;
    }
}
