package com.wesker926.leetcode.algorithms.p1790.s1;

/**
 * @author wesker.gh
 * @date 2022/10/11
 * @description 遍历
 */
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int diff = 0;
        int[] idxs = new int[2];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff > 1) {
                    return false;
                }
                idxs[diff++] = i;
            }
        }
        return diff == 0 ||
                (diff == 2 && s1.charAt(idxs[0]) == s2.charAt(idxs[1])
                        && s1.charAt(idxs[1]) == s2.charAt(idxs[0]));
    }
}
