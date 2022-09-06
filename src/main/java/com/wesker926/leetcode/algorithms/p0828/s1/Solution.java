package com.wesker926.leetcode.algorithms.p0828.s1;

/**
 * @author wesker.gh
 * @date 2022/9/6
 * @description 分别计算每个字符的贡献
 * 乘法计算，每个字符的贡献 = (idx2 - idx1) * (idx3 - idx2)
 * 这样每个字符仅对其无重复字符的字串做贡献
 */
public class Solution {
    public int uniqueLetterString(String s) {
        int[][] mem = new int[26][];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            if (mem[c] == null) {
                mem[c] = new int[3];
                mem[c][1] = -1;
            } else {
                mem[c][0] += (mem[c][2] - mem[c][1]) * (i - mem[c][2]);
                mem[c][1] = mem[c][2];
            }
            mem[c][2] = i;
        }
        int ans = 0;
        for (int[] cur : mem) {
            if (cur != null) {
                ans += cur[0] + (cur[2] - cur[1]) * (s.length() - cur[2]);
            }
        }
        return ans;
    }
}
